<!DOCTYPE html>
<html>
<head>
<title>Create Tutorial</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="common/libraries.jsp" %> 
<link rel="stylesheet" href="quiz/quiz.css">
</head>
<body>
<jsp:include page="common/navbar.jsp" />
<div class="container-fluid" id="quiz">
<div class="row">
<div class="col-sm-1">
</div>
<div class="col-sm-9">
    <button @click="send" v-if="items.length>0" style="display:block;margin:auto;" type="button" class="btn btn-info">
      Commit changes
    </button>
</div>
<div class="col-sm-2">
</div>
</div>
</div>
<script src="quiz/quiz.js"></script>
</body>
</html>