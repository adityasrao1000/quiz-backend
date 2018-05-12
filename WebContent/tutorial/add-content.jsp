<div class="well well-sm well-color">
  <div class="dropdown" style="float:left;">
  <p class="dropdown-toggle" style="width:100%;" data-toggle="dropdown">Add Content <span class="glyphicon glyphicon-plus"></span></p>
  <ul class="dropdown-menu">
    <li><a href="#" @click="insertContent(index+1, 'code')">add code</a></li>
    <li><a href="#" @click="insertContent(index+1, 'paragraph')">add paragraph</a></li>
    <li><a href="#" @click="insertContent(index+1, 'title')">add title</a></li>
    <li><a href="#" @click="insertContent(index+1, 'image-link')">add image-link</a></li>
    <li><a href="#" @click="insertContent(index+1, 'bullet')">add bullets</a></li>
  </ul>
  </div>
  <br>
</div>