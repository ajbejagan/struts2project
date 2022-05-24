<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <div class="flex flex-col items-center min-h-screen bg-gray-200">
        <div class="w-full max-w-screen-lg">
            <header class="py-5">
                <nav class="flex items-center justify-between">
                    <h1 class="text-green-600 font-semibold">Struts2Project</h1>
                    <ul class="flex items-center justify-between">
                    <li class="font-semibold">
                        <s:a class="text-white bg-green-600 px-4 py-2 rounded-md" href="user-list.jsp">Profile</s:a>
                    </li>
                    <li class="font-semibold">
                        <s:a class="text-gray-900 px-4 py-2 rounded-md" href="profile.jsp">User List</s:a>
                    </li>
                    </ul>
                </nav>
            </header>
            <main class="bg-white px-5 py-5 rounded-md">
                <div class="flex flex-col items-center p-2 border border-gray-200 rounded-md">
                  <div class="w-full flex justify-between">
                    <span class="w-[200px] text-sm text-green-600 font-semibold text-center">First name</span>
                    <span class="w-[200px] text-sm text-green-600 font-semibold text-center">Last name</span>
                    <span class="w-[200px] text-sm text-green-600 font-semibold text-center">Username</span>
                    <span class="w-[100px] text-sm text-green-600 font-semibold text-center">Age</span>
                    <span class="w-[200px] text-sm text-green-600 font-semibold text-center">Email</span>
                  </div>
                  <s:iterator  value="users"> 
                  <div class="w-full flex justify-between">
                    <span class="w-[200px] text-sm text-green-600 font-semibold text-center">
                      <s:property value="firstname"/>
                    </span>
                    <span class="w-[200px] text-sm text-green-600 font-semibold text-center">
                      <s:property value="lastname"/>
                    </span>
                    <span class="w-[200px] text-sm text-green-600 font-semibold text-center">
                      <s:property value="username"/>
                    </span>
                    <span class="w-[100px] text-sm text-green-600 font-semibold text-center">
                      <s:property value="age"/>
                    </span>
                    <span class="w-[200px] text-sm text-green-600 font-semibold text-center">
                      <s:property value="email"/>
                    </span>
                  </div>
                  </s:iterator>
                </div>
              </main>
            <footer></footer>
        </div>
    </div>
</body>
</html>