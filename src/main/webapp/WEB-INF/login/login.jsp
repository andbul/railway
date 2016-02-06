<div class="panel panel-success" style="max-width: 35%;" align="left">
                    <div class="panel-heading form-group">
                        <b><span style="color: white; ">
                            Login Form</span> </b>
                    </div>
                    <div class="panel-body" >
                        <form action="j_security_check" method="post" >
                            <div class="form-group">
                                <label>User Name</label>
                                <input
                                    type="text" class="form-control" name="j_username" id="login"
                                    placeholder="Enter User Name" required="required">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input
                                    type="password" class="form-control" name="j_password" id="password"
                                    placeholder="Password" required="required">
                            </div>
                            <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b>Login</b></button>
                        </form>
                        Or <a href="/register">Register</a>
                    </div>
</div>