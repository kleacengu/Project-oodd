

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.klea.test.project.web.WebObjectFactory"%>
<%@page import="org.klea.test.project.model.ServiceFactory"%>
<%@page import="org.klea.test.project.model.ServiceFacade"%>
<%@page import="org.klea.test.project.model.Meter"%>


<%

    ServiceFacade serviceFacade = (ServiceFacade) session.getAttribute("serviceFacade");

    // If the user session has no Meter, create a new one
    if (serviceFacade == null) {
        ServiceFactory serviceFactory = WebObjectFactory.getServiceFactory();
        serviceFacade = serviceFactory.getServiceFacade();
        session.setAttribute("ServiceFacade", serviceFacade);
    }

    // get request values
    String action = (String) request.getParameter("action");
    String meterIdReq = (String) request.getParameter("meterId");
    String locationReq = (String) request.getParameter("location");
    String startTime = (String) request.getParameter("startTime");
 //   double pricePerHalfHour;
 //   String price = Double.toString(pricePerHalfHour);
    String priceHour = (String) request.getParameter("pricePerHalfHour");
    String errorMessage = "";

    Meter meter = null;
    Integer meterId = null;

    if ("modifyMeter".equals(action)) {
        try {
            meterId = Integer.parseInt(meterIdReq);
            meter = serviceFacade.retrieveMeterConfig(meterId);
        } catch (Exception e) {
            errorMessage = "problem finding meter " + e.getMessage();
        }
    } else if ("createMeter".equals(action)) {
        try {
            meter = new Meter();
        } catch (Exception e) {
            errorMessage = "problem finding meter " + e.getMessage();
        }
    } else {
        errorMessage = "cannot recognise action: " + action;
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Edit Meter</title>
    </head>
    <body>
        <%=errorMessage%>
        <% if ("createMeter".equals(action)) {
        %>
        <h1>Add New Meter</h1>
        <% } else {%>
        <h1>Modify Meter <%=meterId%></h1>
        <% }%>
        <form action="ListMeters.jsp">
            <table>
                <tr>
                    <th>Field</th>
                    <th>Current Value</th>
                    <th>New Value</th>
                </tr>
                <tr>
                    <td>Meter Id</td>
                    <td><%=meter.getMeterId()%></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Location</td>
                    <td><%=meter.getLocation()%></td>
                    <td><input type="text" name="location" value ="<%=meter.getLocation()%>"></td>
                </tr>
             </table> 
            <BR>
            <% if ("createMeter".equals(action)) {
            %>
            <input type="hidden" name="action" value="createMeter">
            <input type="hidden" name="meterId" value="">
            <input type="submit" value="Create New Meter">
            <% } else if ("modifyMeter".equals(action)) {
            %>
            <input type="hidden" name="action" value="updateParkingMeter">
            <input type="hidden" name="meterId" value="<%=meterId%>">
            <input type="submit" value="Modify ">
            <% }%>
        </form>
        <form action="ListMeters.jsp">
            <input type="submit" value="Cancel and Return">
        </form>
    </body>
</html>
