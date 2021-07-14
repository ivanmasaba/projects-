<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use  App\Models\customer;
use Validator;

class CustomersController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        header("Content-Type: application/json");
       $customers = customer::get()->toJson(JSON_PRETTY_PRINT);
        return response($customers, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $rules = [
            'fname' => 'required|min:3',
            'lname' => 'required|min:3',
            'email' => 'required'
        ];

        $validator = validator::make($request->all(), $rules);

        if($validator->fails()){
            return response()->json($validator->errors(), 400);
        }
        
    $customer = customer::create($request->all());
       return response()->json([
           "message" => "customer created"
       ], 201);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $customer = customer::find($id);
        if(is_null($customer)){
            return response()->json(["message" => "customer not found"], 404);
        }
        return response()->json($customer, 200);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update($id)
    {
        $customer = customer::find($id);
        if(is_null($customer)){
            return response()->json(["message" => "customer not found"], 404);
        }
        
        
    
        $feed = $customer->update([
            'fname' => request('fname'),
            'lname' => request('lname'),
            'email' => request('email'),
            'phone' => request('phone'),
            'address' => request('address')
        ]);
    
        return[
            'success' => $feed 
         ];
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $customer = customer::find($id);
        if(is_null($customer)){
            return response()->json(["message" => "customer not found"], 404);
        }
        $success = $customer->delete();
 
        return response()->json(["message" => "customer deleted"], 200);
    }
}
