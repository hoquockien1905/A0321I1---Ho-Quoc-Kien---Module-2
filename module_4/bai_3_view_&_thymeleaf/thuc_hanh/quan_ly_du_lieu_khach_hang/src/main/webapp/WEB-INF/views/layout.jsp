<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head th:fragment="head">
    <meta charset="UTF-8">
    <title>Spring customer</title>
    <style type="text/css">
        h3{background-color: blue; color: white; padding: 10px 0 10px 20px;}
        footer{margin: 10px 0;}

        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }

        input[type=text],input[type=email]{
            width: 100%;
            padding: 12px 0px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 300px%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        #form {
            width: 500px;
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .notify span{font-size: 15px; color: blue;}
    </style>
</head>
<body>
<footer th:fragment="footer">
    &copy; 2018 CodeGym
</footer>
</body>
</html>