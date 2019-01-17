

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
    double pricePerHalfHour;
    String price = Double.toString(pricePerHalfHour);
    String priceHour = (String) request.getParameter("pricePerHalfHour");
    String errorMessage = "";

    Meter meter = null;
    Integer meterId = null;

    if ("modifyEntity".equals(action)) {
        try {
            meterId = Integer.parseInt(meterIdReq);
            meter = serviceFacade.retrieveMeterConfig(meterId);
        } catch (Exception e) {
            errorMessage = "problem finding meter " + e.getMessage();
        }
    } else if ("createEntity".equals(action)) {
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
        <% if ("createEntity".equals(action)) {
        %>
        <h1>Add New Meter</h1>
        <% } else {%>
        <h1>Modify Meter <%=meterId%></h1>
        <% }%>
        <form action="ListEntities.jsp">
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
                    <td><input type="text" name="field_A" value ="<%=meter.getLocation()%>"></td>
                </tr>
                <tr>
                    <td>Schedule</td>
                    <td><%=meter.calculateCharge(startTime, pricePerHalfHour)%></td>
                    <td><input type="text" name="field_B" value ="<%=meter.getField_B()%>"></td>
                </tr>
                <tr>
                    <td>field_C</td>
                    <td><%=entity.getField_C()%></td>
                    <td><input type="text" name="field_C" value ="<%=entity.getField_C()%>"></td>
                </tr>
            </table> 
            <BR>
            <% if ("createEntity".equals(action)) {
            %>
            <input type="hidden" name="action" value="createEntity">
            <input type="hidden" name="entityId" value="<%=meterId%>">
            <input type="submit" value="Create New Entity">
            <% } else if ("modifyEntity".equals(action)) {
            %>
            <input type="hidden" name="action" value="modifyEntity">
            <input type="hidden" name="entityId" value="<%=meterId%>">
            <input type="submit" value="Modify Entity">
            <% }%>
        </form>
        <form action="ListEntities.jsp">
            <input type="submit" value="Cancel and Return">
        </form>
    </body>
</html>
