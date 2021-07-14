@extends('layouts.app')

@section('content')
<h1>Edit Product</h1>
 {!! Form::open(['action' => ['App\Http\Controllers\ProductController@update', $product->id]]) !!}
 @csrf
 <div class="form-group">
  {{ Form::label('product name', 'Product name') }}
  {{ Form::text('product', $product->pname, ['class' => 'form-control', 'placeholder' => 'Product name']) }}
 </div> 
 <div class="form-group">
     {{ Form::label('price','Price') }}
     {{ Form::number('price', $product->price, ['class' => 'form-control', 'placeholder' => 'Price']) }}    
</div>
<div class="form-group">
    {{ Form::label('description','Description') }}
    {{ Form::text('description', $product->description, ['class' => 'form-control', 'placeholder' => 'Description']) }}    
</div>
<div class="form-group">
    {{ Form::label('service','Service') }}
    {{ Form::select('service', [1 => 'true', 0 => 'false'], $product->service, ['class' => 'form-control', 'placeholder' => 'Service']) }}    
</div>

{{ Form::hidden('_method', 'PUT') }}
{{ Form::submit('submit', ['class' => 'btn btn-primary']) }}     
{!! Form::close() !!}
    
@endsection