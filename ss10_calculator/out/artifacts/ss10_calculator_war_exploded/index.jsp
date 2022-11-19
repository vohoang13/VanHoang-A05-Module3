<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2022
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
        .button {
            background-color: white;
        }
        table {
            margin: 10px;
            border: 2px black solid;
        }
    </style>
  </head>
  <body>
      <h1>Simple Calculator</h1>
      <table>
          <form action="/calculator">
            <tr>
                <td>
                    <label>First operand:</label>
                </td>
                <td>
                    <input type="number" name="first">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Operator:</label>
                </td>
                <td>
                    <select name="select">
                      <option value="+">Addition</option>
                      <option value="-">Subtraction</option>
                      <option value="*">Multiplication</option>
                      <option value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Second operand:</label></td>
                <td><input type="number" name="second"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate" class="button"></td>
            </tr>
          </form>
      </table>
  </body>
</html>
