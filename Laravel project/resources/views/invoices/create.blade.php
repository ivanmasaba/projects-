@extends('layouts.app')

@section('content')
 <h1>Create Invoice</h1>
 {!! Form::open(['action' => 'App\Http\Controllers\InvoiceController@store']) !!}
 @csrf
 <div class="form-group">
  {{ Form::label('date', 'Date') }}
  {{ Form::date('date', \Carbon\Carbon::now(), ['class' => 'form-control', 'placeholder' => 'date']) }}
 </div> 
 <div class="form-group">
     {{ Form::label('customer','Customer') }}
     {{ Form::text('customer', '', ['class' => 'form-control', 'placeholder' => 'customer']) }}    
</div>
<div class="form-group">
    {{ Form::label('product', 'Product') }}
    {{ Form::text('product', '', ['class' => 'form-control', 'placeholder' => 'Product']) }}
</div>    
{{ Form::submit('submit', ['class' => 'btn btn-primary']) }}     
{!! Form::close() !!}
    
@endsection