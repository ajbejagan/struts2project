<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <main class="flex items-center justify-center min-h-screen bg-gray-200">
        <form class="flex flex-col items-center justify-center bg-white px-16 py-14 rounded-md shadow-md" action="RegisterAction">
            <h1 class="text-2xl text-green-600 font-bold mb-5">Create Account</h1>
            <div class="flex items-center justify-between">
                <input class="w-60 p-2 border border-gray-200 rounded-md mr-2 mb-2" type="text" name="userBean.firstname" id="firstname" placeholder="firstname">
                <input class="w-60 p-2 border border-gray-200 rounded-md mb-2" type="text" name="userBean.lastname" id="lastname" placeholder="lastname">
            </div>
            <div class="flex items-center justify-between">
                <input class="w-60 p-2 border border-gray-200 rounded-md mr-2 mb-2" type="email" name="userBean.email" id="email" placeholder="email">
                <input class="w-60 p-2 border border-gray-200 rounded-md mb-2 appearance-none" type="number" name="userBean.age" id="age" placeholder="age">
            </div>
            <div class="flex items-center justify-between">
                <input class="w-60 p-2 border border-gray-200 rounded-md mr-2 mb-2" type="text" name="userBean.username" id="username" placeholder="username">
                <input class="w-60 p-2 border border-gray-200 rounded-md mb-2" type="password" name="userBean.password" id="password" placeholder="password">
            </div>
            <button class="w-full text-white font-semibold p-2 bg-green-500 border border-green-600 rounded-md mb-4" type="submit">Create Account</button>
            <p class="text-sm text-gray-400">Already have an account? <s:a class="underline" href="index.jsp">Login</s:a></p>
        </form>
      </main>
</body>
</html>