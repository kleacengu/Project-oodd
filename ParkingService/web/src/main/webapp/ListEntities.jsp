
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.klea.test.project.web.WebObjectFactory"%>
<%@page import="org.klea.test.project.model.ServiceFactory"%>
<%@page import="org.klea.test.project.model.ServiceFacade"%>
<%@page import="org.klea.test.project.model.Meter"%>

<%

    ServiceFacade serviceFacade = (ServiceFacade) session.getAttribute("serviceFacade");

    // If the user session has no meter, create a new one
    if (serviceFacade == null) {
        ServiceFactory serviceFactory = WebObjectFactory.getServiceFactory();
        serviceFacade = serviceFactory.getServiceFacade();
        session.setAttribute("ServiceFacade", serviceFacade);
    }

    // get request values
    String action = (String) request.getParameter("action");
    String meterId = (String) request.getParameter("meterId");
    String location = (String) request.getParameter("location");
    
    String errorMessage = "";
    if ("deleteParkingMeter".equals(action)) {
        try {
            Integer MeterId = Integer.parseInt(meterId);
            serviceFacade.deleteParkingMeter(MeterId);
        } catch (Exception e) {
            errorMessage = "problem deleting Meter " + e.getMessage();
        }
    } else if ("updateParkingMeter".equals(action)) {
        try {
            Integer MeterId = Integer.parseInt(meterId);
            Meter meter = new Meter();
            meter.setLocation(location);
           
            Meter meterUpdateService = serviceFacade.updateParkingMeter(meter);
            if (MeterId == null) {
                errorMessage = "problem modifying Meter. could not find meterId " + MeterId;
            }
        } catch (Exception e) {
            errorMessage = "problem modifying Meter " + e.getMessage();
        }
    } else if ("createMeter".equals(action)) {
        try {
            Meter meter = new Meter();
            meter.setLocation(location);
            Meter meterCreateService = serviceFacade.createParkingMeter(meter);
            if (meter == null) {
                errorMessage = "problem creating Meter. Service returned null ";
            }
        } catch (Exception e) {
            errorMessage = "problem creating  Meter " + e.getMessage();
        }
    } 

    List<Meter> MeterList = serviceFacade.retreiveAllMeters();

%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Meter List</title>
    </head>
    <body>
        <!-- print error message if there is one -->
        <div style="color:red;"><%=errorMessage%></div>
        <h1>Meter List</h1>
        <table>
            <tr>
                <th>Meter Id</th>
                <th>Location</th>
            </tr>
            <%  for (Meter entity : MeterList) {
            %>
            <tr>
                <td><%=entity.getMeterId()%></td>
                <td><%=entity.getLocation()%></td>
                <td>
                    <form action="AddOrModifyEntity.jsp">
                        <input type="hidden" name="action" value="modifyMeter">
                        <input type="hidden" name="meterId" value="<%=entity.getMeterId()%>">
                        <input type="submit" value="Modify EntityMeter">
                    </form>
                    <form action="ListEntities.jsp">
                        <input type="hidden" name="action" value="deleteEntity">
                        <input type="hidden" name="entityId" value="<%=entity.getMeterId()%>">
                        <input type="submit" value="Delete Entity">
                    </form>
                </td>
            </tr>
            <% }%>

        </table> 
        <BR>
        <form action="AddOrModifyEntity.jsp">
            <input type="hidden" name="action" value="createEntity">
            <input type="submit" value="Create Entity">
        </form>
    </body>
</html>
