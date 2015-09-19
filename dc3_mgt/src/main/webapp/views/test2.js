define(["application-configuration"], function(app){
	app.register.service("test2", function(){
		this.say = function(){
			return "hello";
		}
	})
})