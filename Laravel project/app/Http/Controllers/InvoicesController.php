<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use  App\Models\invoice;

use Validator;

class InvoicesController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return invoice::all();
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
            'date' => 'required',
            'customer' => 'required|min:3',
            'product' => 'required'
        ];

        $validator = validator::make($request->all(), $rules);

        if($validator->fails()){
            return response()->json($validator->errors(), 400);
        }
    
        $invoice = invoice::create($request->all());

        return response()->json([
            "message" => "invoice created"
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
        $invoice = invoice::find($id);
        if(is_null($invoice)){
            return response()->json(["message" => "invoice not found"], 404);
        }
        return response()->json($invoice, 200);
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
        $invoice = invoice::find($id);
        if(is_null($invoice)){
            return response()->json(["message" => "invoice not found"], 404);
        }
        request()->validate([
            'date' => 'required',
            'customer' => 'required',
            'product' => 'required'
        ]);
    
        $feed = $invoice->update([
            'date' => request('date'),
            'customer' => request('customer'),
            'product' => request('product')
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
        $invoice = invoice::find($id);
        if(is_null($invoice)){
            return response()->json(["message" => "invoice not found"], 404);
        }
        $success = $invoice->delete();
 
        return response()->json(["message" => "invoice deleted"], 200);
    }
}
