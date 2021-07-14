<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use  App\Models\product;
use Validator;

class ProductsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return product::all();
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
            'pname' => 'required|min:3',
            'price' => 'required'
        ];

        $validator = validator::make($request->all(), $rules);

        if($validator->fails()){
            return response()->json($validator->errors(), 400);
        }
    
        $product = product::create([
            'pname' => request('pname'),
            'price' => request('price'),
            'description' => request('description'),
            'service' => request('service')
        ]);

        return response()->json([
            "message" => "product created"
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
        
        $product = product::find($id);
        if(is_null($product)){
            return response()->json(["message" => "product not found"], 404);
        }
        return response()->json($product, 200);
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
        $product = product::find($id);
        if(is_null($product)){
            return response()->json(["message" => "product not found"], 404);
        }
        request()->validate([
            'pname' => 'required',
            'price' => 'required'
        ]);
    
        $feed = $product->update([
            'pname' => request('pname'),
            'price' => request('price'),
            'description' => request('description'),
            'service' => request('service')
        ]);
    
        return[
            "message" => "product updated"
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
        $product = product::find($id);
        if(is_null($product)){
            return response()->json(["message" => "product not found"], 404);
        }
        $success = $product->delete();
 
        return response()->json(["message" => "product deleted"], 200);
    }
}
