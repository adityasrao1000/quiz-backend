
var vm = new Vue({
	  el: '#index',
	  data: {
		  tutorial: 'javascript',
		  section: 'overview',
	      items: [],
          tutorials: [],
          sections: []
	  },
	  methods: {
		  submit: function(){
			  let obj = JSON.stringify({code: text.value.trim()});
			  pre.innerHTML = JSON.parse(obj).code;
		  },
		  send: function(){
			  let items = this.items;
			  let url = "tutorial/"+this.tutorial+"/"+this.section;
			  axios({
				  method: 'post',
				  url: url,
				  data: items,
				  headers: { contentType: "application/json; charset=utf-8"}
				})
				.then(function (response) {
				    console.log(response);
			    })
			    .catch(function (error) {
			        console.log(error);
			    });
		  },
		  insert: function(event, index) {
			  this.items[index].item = event.target.value;
		  },
		  deleteItem: function(index){
			  this.items.splice(index, 1);
		  },
		  insertContent: function(pos, type){
			  if(type==='code'){
				  let language = this.selectedLanguage;
				  this.items.splice(pos,0,{"item":"","type":"code", "language": "javascript"});
			  }
			  if(type==='paragraph'){
				  this.items.splice(pos,0,{"item":"","type":"paragraph"});
			  }
			  if(type==='title'){
				  this.items.splice(pos,0,{"item":"","type":"title"});
			  }
			  if(type==='image-link'){
				  this.items.splice(pos,0,{"item":"","type":"image-link"});
			  }
			  if(type==='bullet'){
				  this.items.splice(pos,0,{"item":[''],"type":"bullet"});
			  }
		  },
		  updateLanguage: function(event, index) {
			    this.items[index].language = event.target.value;
		  },
		  insertbulletValue: function(event, index, subindex){
			  this.items[index].item[subindex] = event.target.value;
			  this.items[index].item.push(' ');
			  this.items[index].item.pop();
		  },
		  addSubBulletItem: function(index){
			  this.items[index].item.push(' ');
		  },
		  imageFailed: function(event){
			  event.target.src="https://energywater.gr/wp-content/uploads/2017/12/noimage-9-1000x1000.png";
		  },
		  updatetutorial: function(){
			  this.sections =[];
			  let url = 'getsection/'+this.tutorial;
			  axios({
				  method: 'get',
				  url: url
				})
				.then(function (response) {
				    if(response.data.length > 0){
				     response.data.forEach(result => vm.sections.push(result) );
				     vm.section = vm.sections[0];
				     vm.updateJsonObject();
				    }
			    })
			    .catch(function (error) {
			        console.log(error);
			    });
		  },
		  updatefile: function(event){
			  this.tutorial = event.target.value;
			  this.updatetutorial();
		  },
		  updateJsonObject: function(event){
			  if(event){
			    this.section = event.target.value;
			  }
			  this.items =[];
			  let url = 'gettutorial/'+this.tutorial+"/"+this.section;
			  axios({
				  method: 'get',
				  url: url
				})
				.then(function (response) {
					if(response.data.length > 0){
					     response.data.forEach(result => vm.items.push(result) );
					    }
			    })
			    .catch(function (error) {
			        console.log(error);
			    });
		  }
	  },
	  mounted: function(){
		  let self = this;
		  axios({
			  method: 'get',
			  url: 'directories'
			})
			.then(function (response) {
			    if(response.data.length > 0){
			     response.data.forEach(result => vm.tutorials.push(result) );
			     self.updatetutorial();
			    }
		    })
		    .catch(function (error) {
		        console.log(error);
		    });
	  }
});