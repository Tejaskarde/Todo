package com.example.todo.contoller;


import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 what we are doing
 Create Todo, Delete Todo, Update ,Fetch Todo(Crud Operation)


 */

//to tell spring it is controoler
// we can use in place of responsebody


//       @RequestMapping("message")
     //  @ResponseBody    // inplace of this we can use common for all method return to
//      public String message(){
//          return "Good Evening";

     //creating todo
    //@RequestMapping("/create.todo/id/{id}/title/{title}")
    //APP: CREATE<FETCH<UPDATE<DELETE

@RestController
@RequestMapping("/api/v1/todo-app")/// all url will start with api/v1/todo-app/----//
//@Controller
public class TodoController {
      private  final TodoService todoService;

      public TodoController(TodoService todoService){
          this.todoService = todoService;
      }

//    @RequestMapping(value="",method = RequestMethod.POST) in palace of this we can use
   // posting data to data base
    //http://localhost:8080/api/v1/todo-app/add-todo ----- posting it from postman
@PostMapping("/add-todo")
public void addTodo(@RequestBody Todo todo){
      //add todo
        todoService.addTodo(todo);
     }



     //get or fetch data  for single id
    //http://localhost:8080/api/v1/todo-app/find-todo/id/2
     @GetMapping("/find-todo/id/{id}")
    public Todo findTodoById(@PathVariable int id){

        return todoService.findById(id);

     }
        ///




    //Read----- Command from CURD
    // object mapper converting format it to json;
     //http://localhost:8080/api/v1/todo-app/find-all    //-after entering on link on chrome we get json format info
     @GetMapping("find-all")
    public List<Todo> findAllTodo(){  // controller talking to service layer

    return  todoService.findAll();

     }






//http://localhost:8080/api/v1/todo-app/update-todo/id/4
    // @RequestMapping(value = "",method = RequestMethod.PUT)
    @PutMapping("update-todo/id/{id}")
    public void update(@PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(id,todo);
        // to update the things
     }





    ////////-----http://localhost:8080/api/v1/todo-app/delete-todo/id/1---//
//
      @DeleteMapping("delete-todo/id/{id}")
    public void deleteTodo(@PathVariable int id){
            todoService.deleteTodo(id);
      }


//     @RequestMapping("/api")    // made url  http://localhost:8080/api?username=Tejas
//    public String hellowUser(@RequestParam String username){//this username should match exact to webpage
//        // we can change name also (@RequestParam("username") String userName) we can do this
//        return "hello "+username;
//    }
//    @RequestMapping("/api/username/{username}")    // made url  http://localhost:8080/api/username/tejas  it well aslo work
//    public String hellowUser(@PathVariable String username){//this username should match exact to webpage
//        // we can change name also (@RequestParam("username") String userName) we can do this
//        return "hello "+username;
//    }

      }


