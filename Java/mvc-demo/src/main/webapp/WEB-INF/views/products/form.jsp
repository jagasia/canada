<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${empty product.id ? 'Create Product' : 'Edit Product'}</title>
    <style>
        body { font-family: Arial, sans-serif; background: linear-gradient(135deg, #f5f7ff, #eef7f0); margin: 0; padding: 0; }
        .container { max-width: 700px; margin: 50px auto; background: white; padding: 30px; border-radius: 16px; box-shadow: 0 10px 35px rgba(0,0,0,0.12); }
        h1 { color: #0f766e; margin-bottom: 8px; }
        .subtitle { color: #64748b; margin-bottom: 20px; }
        .form-group { margin-bottom: 16px; }
        label { display: block; margin-bottom: 6px; font-weight: bold; color: #334155; }
        input { width: 100%; padding: 10px 12px; border: 1px solid #cbd5e1; border-radius: 8px; box-sizing: border-box; }
        .error { color: #dc2626; font-size: 0.9em; margin-top: 4px; }
        .actions { display: flex; gap: 12px; margin-top: 20px; }
        .btn { display: inline-block; padding: 10px 16px; border-radius: 8px; text-decoration: none; font-weight: bold; border: none; cursor: pointer; }
        .btn-primary { background: #0f766e; color: white; }
        .btn-secondary { background: #e2e8f0; color: #0f172a; }
    </style>
</head>
<body>
<div class="container">
    <h1>${empty product.id ? 'Create New Product' : 'Edit Product'}</h1>
    <p class="subtitle">Fill in the product details below and save it instantly.</p>

    <form:form modelAttribute="product" method="post" action="${pageContext.request.contextPath}/products/save">
        <form:hidden path="id" />

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="name" id="name" />
            <form:errors path="name" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <form:input path="category" id="category" />
            <form:errors path="category" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="price" id="price" />
            <form:errors path="price" cssClass="error" />
        </div>

        <div class="actions">
            <button class="btn btn-primary" type="submit">Save Product</button>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/products">Cancel</a>
        </div>
    </form:form>
</div>
</body>
</html>
