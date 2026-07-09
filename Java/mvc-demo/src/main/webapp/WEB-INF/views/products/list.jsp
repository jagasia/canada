<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Catalog</title>
    <style>
        body { font-family: Arial, sans-serif; background: linear-gradient(135deg, #f5f7ff, #e8f0ff); margin: 0; padding: 0; }
        .container { max-width: 1100px; margin: 40px auto; background: white; padding: 30px; border-radius: 16px; box-shadow: 0 10px 35px rgba(0,0,0,0.12); }
        h1 { color: #1d4ed8; margin-bottom: 10px; }
        .subtitle { color: #64748b; margin-bottom: 20px; }
        .actions { display: flex; justify-content: space-between; align-items: center; margin-bottom: 16px; }
        .btn { display: inline-block; padding: 10px 16px; border-radius: 8px; text-decoration: none; font-weight: bold; }
        .btn-primary { background: #2563eb; color: white; }
        .btn-danger { background: #dc2626; color: white; }
        .btn-secondary { background: #e2e8f0; color: #0f172a; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        th, td { padding: 12px; border-bottom: 1px solid #e2e8f0; text-align: left; }
        th { background: #eff6ff; color: #1e3a8a; }
        .message { padding: 12px 16px; margin-bottom: 16px; border-radius: 8px; background: #dcfce7; color: #166534; }
        .empty { color: #64748b; padding: 20px 0; }
    </style>
</head>
<body>
<div class="container">
    <h1>Product Catalog</h1>
    <p class="subtitle">Manage your inventory with a polished product dashboard.</p>

    <c:if test="${not empty message}">
        <div class="message">${message}</div>
    </c:if>

    <div class="actions">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/products/new">Add Product</a>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/">Back Home</a>
    </div>

    <c:choose>
        <c:when test="${not empty products}">
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.category}</td>
                        <td>$${product.price}</td>
                        <td>
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/products/edit/${product.id}">Edit</a>
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/products/delete/${product.id}" onclick="return confirm('Delete this product?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="empty">No products available yet. Create your first one to get started.</div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
