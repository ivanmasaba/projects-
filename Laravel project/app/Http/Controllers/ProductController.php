<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\product;

class ProductController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $products = product::orderBy('created_at','desc')->simplePaginate(3);
       return view('products.index')->with('products', $products);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
       return view('products.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $this->validate($request,[
            'product' => 'required',
            'price' => 'required',
            'description' => 'required',
            'service' => 'required'
        ]);

        // create Customer
        $product = new product;
        $product->pname = $request->input('product');
        $product->price = $request->input('price');
        $product->description = $request->input('description');
        $product->service = $request->input('service');
        $product->save();

        return redirect('/products')->with('success', 'product created');
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
        return view('products.show')->with('product', $product);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $product = product::find($id);
        return view('products.edit')->with('product', $product);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $this->validate($request,[
            'product' => 'required',
            'price' => 'required',
            'description' => 'required',
            'service' => 'required'
        ]);

        // create Customer
        $product = product::find($id);
        $product->pname = $request->input('product');
        $product->price = $request->input('price');
        $product->description = $request->input('description');
        $product->service = $request->input('service');
        $product->save();

        return redirect('/products')->with('success', 'product updated');
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
        $product->delete();

        return redirect('/products')->with('success', 'product Deleted');
    }
}
