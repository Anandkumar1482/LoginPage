<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
    <style>
        /* Basics */
        html, body
        {
            padding: 0;
            margin: 0;
            width: 100%;
            height: 100%;
            font-family: "Helvetica Neue" , Helvetica, sans-serif;
            background: #FFFFFF;
        }
        .logincontent
        {
            position: fixed;
            width: 350px;
            height: 580px;
            top: 30%;
            left: 50%;
            margin-top: -150px;
            margin-left: -175px;
            background-color:DodgerBlue;
            padding-top: 8px;
        }
        .loginheading
        {
            border-bottom: solid 1px #ECF2F5;
            padding-left: 60px;
            padding-bottom: 10px;
            color: #ffffff;
            font-size: 25px;
            font-weight: bold;
            font-family: sans-serif;
        }
        label
        {
            color: #ffffff;
            display: inline-block;
            margin-left: 18px;
            padding-top: 10px;
            font-size: 15px;
        }
        input[type=text], input[type=password]
        {
            font-size: 14px;
            padding-left: 10px;
            margin: 10px;
            margin-top: 12px;
            margin-left: 18px;
            width: 300px;
            height: 35px;
            border: 1px solid #ccc;
            border-radius: 2px;
            box-shadow: inset 0 1.5px 3px rgba(190, 190, 190, .4), 0 0 0 5px #f5f5f5;
            font-size: 14px;
        }
        input[type=checkbox]
        {
            margin-left: 18px;
            margin-top: 30px;
        }
        
        .check
        {
            font-family: sans-serif;
            position: relative;
            top: -2px;
            margin-left: 2px;
            padding: 0px;
            font-size: 12px;
            color: #321;
        }
       
        .loginbtn:hover
        {
            background-image: -webkit-gradient(linear, left top, left bottom, from(#b6e2ff), to(#6ec2e8));
            background-image: -moz-linear-gradient(top left 90deg, #b6e2ff 0%, #6ec2e8 100%);
            background-image: linear-gradient(top left 90deg, #b6e2ff 0%, #6ec2e8 100%);
        }
    </style>
</head>
<body>
<form action="Registor" method="post">
    <div class="logincontent">
        <div class="loginheading">
           Registration Form
        </div>     
        <label for="FirstName">
           FirstName:</label>
        <input type="text"   placeholder="FirstName"name="FirstName" />
       
        <label for="LastName">
            LastName:</label>
        <input type="text" placeholder="LastName" name="LastName" />
        
         <label for="UserName">
            UserName:</label>
        <input type="text"  placeholder="UserName" name="UserName" />
        
           <label for="Password">
            Password:</label>
        <input type="Password"  placeholder="Password" name="Password" />
        
         <label for="Email">
            Email:</label>
        <input type="text" pattern="[a-zA-Z0-9.!#$%&amp;’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)+" title="the mail should be like valid@gmail.com" placeholder="valid@gmail.com" name="Email" />
        
        <br> <br><label for="Submit"></label>
           <input type="submit"  value="submit" />
         
        </div>
        </form>
</body>
</html>