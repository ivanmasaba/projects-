@extends('layouts.app')

@section('content')
 <h1>Edit Customer</h1>
 {!! Form::open(['action' => ['App\Http\Controllers\CustomerController@update', $customer->id] ]) !!}
 @csrf
 <div class="form-group">
    {{ Form::label('first name', 'First name') }}
    {{ Form::text('firstname', $customer->fname, ['class' => 'form-control', 'placeholder' => 'First name']) }}
   </div> 
   <div class="form-group">
       {{ Form::label('last name','Last name') }}
       {{ Form::text('lastname', $customer->lname, ['class' => 'form-control', 'placeholder' => 'Last name']) }}    
  </div>
  <div class="form-group">
      {{ Form::label('email', 'Email') }}
      {{ Form::email('email', $customer->email, ['class' => 'form-control', 'placeholder' => 'Email']) }}
     </div> 
     <div class="form-group">
         {{ Form::label('phone','Phone') }}
         {{ Form::tel('phone', $customer->phone, ['class' => 'form-control', 'placeholder' => 'Phone']) }}    
    </div>
    <div class="form-group">
      {{ Form::label('address', 'Address') }}
      {{ Form::text('address', $customer->address, ['class' => 'form-control', 'placeholder' => 'Address']) }}
     </div>
{{ Form::hidden('_method', 'PUT') }}
{{ Form::submit('submit', ['class' => 'btn btn-primary']) }}     
{!! Form::close() !!}
    
@endsection