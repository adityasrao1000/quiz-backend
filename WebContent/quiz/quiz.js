
var vm = new Vue({
	  el: '#quiz',
	  data: {
		  tutorial: 'javascript',
		  section: 'javascript-1',
	      items: [],
          tutorials: [],
          sections: []
	  },
	  methods: {
		insetContent: function(){
			this.items.push({"question": [{"paragraph": ""}],"options": ["", ""],"option": -1,"answer": {"correct_answer": 0}});
		},
		updatetutorial: function(){
			  this.sections =[];
			  let url = 'getquizsection/'+this.tutorial;
			  axios({
				  method: 'get',
				  url: url
				})
				.then(function (response) {
					
					//if folder has pages
				    if(response.data.length > 0){
				     response.data.forEach(result => vm.sections.push(result) );
				     vm.section = vm.sections[0];
				     vm.updateJsonObject();
				    }else{
				    	//if folder is empty
						vm.items = [];
						vm.section = '';
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
			  let url = 'getquiz/'+this.tutorial+"/"+this.quiz;
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
			},
			send: function(){

			}  
	  },
	  mounted: function(){
		  let self = this;
		  axios({
			  method: 'get',
			  url: 'quizdirectories'
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