<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Role" %>
<div class="panel panel-success" style="max-width: 35%;" align="left">
<div class="panel-heading form-group">
    <b><span style="color: white; ">
                            Admin Add User Form</span> </b>
</div>
<div class="panel-body" >
    <form action="/adminpanel/update" method="post" >
        <jsp:useBean id="user" scope="request" class="entity.User"/>
        <div class="form-group">
            <label>User Login</label>

            <input
                    type="text" class="form-control" name="login" id="login"
                    placeholder="Enter User Login" value="${user.login}" readonly="readonly">
        </div>
        <div class="form-group">
            <label>Password</label>
            <input
                    type="text" class="form-control" name="password" id="password"
                    placeholder="Password" required="required" value=${user.password}>
        </div>
        <div class="form-group">
            <label>Email</label>
            <input
                    type="text" class="form-control" name="email" id="email"
                    placeholder="Enter Email" required="required" value=${user.email}>
        </div>
        <div class="form-group">
            <label>Name</label>
            <input
                    type="text" class="form-control" name="name" id="name"
                    placeholder="Enter Name" value=${user.name}>
        </div>
        <div class="form-group">
            <label>Surname</label>
            <input
                    type="text" class="form-control" name="surname" id="surname"
                    placeholder="Enter Surname" value=${user.surname}>
        </div>

        <div class="form-group">
            <label>Roles</label>
            <%
                String rolestr = "";
                for (Role role : user.getRoles()) {
                    rolestr += role.getName()+" ";
                }
                request.setAttribute("rolestr", rolestr.trim());
            %>
            <input
                    type="text" class="form-control" name="roles" id="roles"
                    placeholder="Enter Role" value="${rolestr}"/>
        </div>

        <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b>Update</b></button>
    </form>
</div>
</div>
