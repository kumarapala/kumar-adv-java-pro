<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<title>edit form</title>
 <!-- BootStrap CDN link to Get the Support of BootStrap -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
		<!-- This is Java script validation code location -->
	  <script src="formvalidation.js"></script>
</head>
<body>
	<div class="container mt-5 text-center">
		<h2 class="text-center font-italic mb-1">Save Product Data.....</h2>
		 <form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return validateForm()">
      
      		<div class="form-group">
                <label class="font-italic font-weight-bold" for="proId">Product ID:</label>
                <input type="text" class="form-control-sm" id="proId" name="proId"  value="${existingProduct.proId}"  required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="proName">Product Name:</label>
                <input type="text" class="form-control-sm" id="proName" name="proName" value="${existingProduct.proName}" required>
            </div>

 			<div class="form-group">
                <label class="font-italic font-weight-bold" for="proPrice">proPrice:</label>
                <input type="number" class="form-control-sm" id="proPrice" name="proPrice" value="${existingProduct.proPrice}" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="proBrand">proBrand:</label>
                <input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingProduct.proBrand}" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="proMadeIn">Made In:</label>
                <input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existingProduct.proMadeIn}" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="proMfgDate">Manufacturing Date:</label>
                <input type="date" class="form-control-sm" id="proMfgDate" name="proMfgDate" value="${existingProduct.proMfgDate}" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="proExpDate">Expiry Date:</label>
                <input type="date" class="form-control-sm" id="proExpDate" name="proExpDate" value="${existingProduct.proExpDate}" required>
            </div>

  <!-- Display the current product image -->
<div class="form-group">
    <label class="font-italic font-weight-bold" for="proImage">Current Product Image:</label>
    <img id="currentImage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.proImage)}" alt="Current Product Image" style="max-width: 100px; max-height: 100px;">
	<input type="hidden" id="existingImage" name="existingImage" value="${existingProduct.proImage}"/>
</div>

<!-- Allow the user to upload a new image -->
<div class="form-group">
    <label class="font-italic font-weight-bold" for="newProImage">New Product Image:</label>
    <input type="file" class="form-control-file-sm" id="newProImage" name="newProImage" accept="image/*">
</div>

			
			<div>
                <input type="submit" class="btn btn-success" value="Update product"/>
            </div>
  
        </form>			
</div>
</body>
</html>