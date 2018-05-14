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
    <div class="well well-sm well-color">
      <div class="dropdown" style="float:left;">
      <p class="dropdown-toggle" style="width:100%;" data-toggle="dropdown">Add Content <span class="glyphicon glyphicon-plus"></span></p>
      <ul class="dropdown-menu">
        <li><a href="#" @click="insertContent(0, 'quiz')">add quiz</a></li>
      </ul>
      </div>
      <br>
    </div>
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