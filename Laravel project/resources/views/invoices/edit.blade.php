@extends('layouts.app')

@section('content')
 <h1>Edit Invoice</h1>
 {!! Form::open(['action' => ['App\Http\Controllers\InvoiceController@update', $invoice->id] ]) !!}
 @csrf
 <div class="form-group">
  {{ Form::label('date', 'Date') }}
  {{ Form::date('date', $invoice->date, ['class' => 'form-control', 'placeholder' => 'Date']) }}
 </div> 
 <div class="form-group">
     {{ Form::label('customer','Customer') }}
     {{ Form::textarea('customer', $invoice->customer, ['class' => 'form-control', 'placeholder' => 'Customer']) }}    
</div>
<div class="form-group">
    {{ Form::label('product', 'Product') }}
    {{ Form::text('product', $invoice->product, ['class' => 'form-control', 'placeholder' => 'Product']) }}
</div> 
{{ Form::hidden('_method', 'PUT') }}
{{ Form::submit('submit', ['class' => 'btn btn-primary']) }}     
{!! Form::close() !!}
    
@endsection