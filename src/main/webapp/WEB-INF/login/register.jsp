<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 04.02.16
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<div class="panel panel-success" style="max-width: 35%;" align="left">
    <div class="panel-heading form-group">
        <b><span style="color: white; ">
                            Registration  Form</span> </b>
    </div>
    <div class="panel-body" >
        <form action="/register" method="post" >
            <div class="form-group">
                <label>User Login</label>
                <input
                        type="text" class="form-control" name="login" id="login"
                        placeholder="Enter User Login" required="required">
            </div>
            <div class="form-group">
                <label>Password</label>
                <input
                        type="password" class="form-control" name="password" id="password"
                        placeholder="Password" required="required">
            </div>
            <div class="form-group">
                <label>Email</label>
                <input
                        type="text" class="form-control" name="email" id="email"
                        placeholder="Enter Email" required="required">
            </div>
            <div class="form-group">
                <label>Name</label>
                <input
                        type="text" class="form-control" name="name" id="name"
                        placeholder="Enter Name">
            </div>
            <div class="form-group">
                <label>Surname</label>
                <input
                        type="text" class="form-control" name="surname" id="surname"
                        placeholder="Enter Surname">
            </div>

            <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b>Register</b></button>
        </form>
    </div>
</div>