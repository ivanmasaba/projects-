<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\invoice;

class InvoiceController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $invoices = invoice::orderBy('created_at','desc')->simplePaginate(3);
       return view('invoices.index')->with('invoices', $invoices);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
       return view('invoices.create');
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
            'date' => 'required',
            'customer' => 'required',
            'product' => 'required'
        ]);

        // create Customer
        $invoice = new invoice;
        $invoice->date = $request->input('date');
        $invoice->customer = $request->input('customer');
        $invoice->product = $request->input('product');
        $invoice->save();

        return redirect('/invoices')->with('success', 'invoice created');
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
        return view('invoices.show')->with('invoice', $invoice);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $invoice = invoice::find($id);
        return view('invoices.edit')->with('invoice', $invoice);
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
            'date' => 'required',
            'customer' => 'required',
            'product' => 'required'
        ]);

        // create Customer
        $invoice = invoice::find($id);
        $invoice->date = $request->input('date');
        $invoice->customer = $request->input('customer');
        $invoice->product = $request->input('product');
        $invoice->save();

        return redirect('/invoices')->with('success', 'Invoice updated');
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
        $invoice->delete();

        return redirect('/invoices')->with('success', 'Invoice Deleted');
    }
}
