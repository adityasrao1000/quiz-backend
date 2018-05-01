<div class="well well-sm">
  <div class="dropdown" style="float:left;">
  <p class="dropdown-toggle" data-toggle="dropdown">Add Content <span class="glyphicon glyphicon-plus"></span></p>
  <ul class="dropdown-menu">
    <li><a href="#" @click="insertContent(index+1, 'code')">add code</a></li>
    <li><a href="#" @click="insertContent(index+1, 'paragraph')">add paragraph</a></li>
    <li><a href="#" @click="insertContent(index+1, 'title')">add title</a></li>
  </ul>
  </div>
  <br>
</div>