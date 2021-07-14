@extends('layouts.app')

@section('content')
 <h1>Create Product</h1>
 {!! Form::open(['action' => 'App\Http\Controllers\ProductController@store']) !!}
 @csrf
 <div class="form-group">
  {{ Form::label('pname', 'Product name') }}
  {{ Form::text('product', '', ['class' => 'form-control', 'placeholder' => 'Product name']) }}
 </div> 
 <div class="form-group">
     {{ Form::label('price','Price') }}
     {{ Form::number('price', '', ['class' => 'form-control', 'placeholder' => 'Price']) }}    
</div>
<div class="form-group">
    {{ Form::label('description','Description') }}
    {{ Form::text('description', '', ['class' => 'form-control', 'placeholder' => 'Description']) }}    
</div>
<div class="form-group">
    {{ Form::label('service','Service') }}
    {{ Form::select('service', [1 => 'true', 0 => 'false'], 0, ['class' => 'form-control', 'placeholder' => 'Service']) }}    
</div>
{{ Form::submit('submit', ['class' => 'btn btn-primary']) }}     
{!! Form::close() !!}
    
@endsection