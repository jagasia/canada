<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome to Product Hub</title>
    <style>
        body { font-family: Arial, sans-serif; background: linear-gradient(135deg, #eef2ff, #ecfeff); margin: 0; padding: 0; }
        .hero { max-width: 900px; margin: 60px auto; background: white; border-radius: 20px; padding: 40px; box-shadow: 0 15px 40px rgba(0,0,0,0.12); }
        h1 { color: #1d4ed8; margin-bottom: 10px; }
        p { color: #475569; font-size: 1.05rem; }
        .actions { margin-top: 22px; }
        .btn { display: inline-block; padding: 12px 18px; border-radius: 10px; text-decoration: none; font-weight: bold; margin-right: 12px; }
        .btn-primary { background: #2563eb; color: white; }
        .btn-secondary { background: #e2e8f0; color: #0f172a; }
        .stats { display: flex; gap: 16px; margin-top: 24px; flex-wrap: wrap; }
        .card { background: #f8fafc; border: 1px solid #e2e8f0; border-radius: 12px; padding: 16px; min-width: 180px; }
    </style>
</head>
<body>
<div class="hero">
    <h1>Welcome to the Product Hub</h1>
    <p>Create, browse, update, and delete products through a modern Spring MVC experience.</p>

    <div class="actions">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/products">View Products</a>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/products/new">Add Product</a>
    </div>

    <div class="stats">
        <div class="card">
            <strong>CRUD Ready</strong>
            <div>Full create, read, update, delete flow</div>
        </div>
        <div class="card">
            <strong>H2 Database</strong>
            <div>In-memory persistence for fast demos</div>
        </div>
        <div class="card">
            <strong>Modern UI</strong>
            <div>JSP views with polished styling</div>
        </div>
    </div>
</div>
</body>
</html>