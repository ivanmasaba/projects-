@extends('layouts.app')

@section('content')
 <h1>Create Customer</h1>
 {!! Form::open(['action' => 'App\Http\Controllers\CustomerController@store']) !!}
 @csrf
 <div class="form-group">
  {{ Form::label('fname', 'First name') }}
  {{ Form::text('firstname', '', ['class' => 'form-control', 'placeholder' => 'First name']) }}
 </div> 
 <div class="form-group">
     {{ Form::label('lname','Last name') }}
     {{ Form::text('lastname', '', ['class' => 'form-control', 'placeholder' => 'Last name']) }}    
</div>
<div class="form-group">
    {{ Form::label('email', 'Email') }}
    {{ Form::email('email', '', ['class' => 'form-control', 'placeholder' => 'Email']) }}
   </div> 
   <div class="form-group">
       {{ Form::label('phone','Phone') }}
       {{ Form::tel('phone', '', ['class' => 'form-control', 'placeholder' => 'Phone']) }}    
  </div>
  <div class="form-group">
    {{ Form::label('address', 'Address') }}
    {{ Form::text('address', '', ['class' => 'form-control', 'placeholder' => 'Address']) }}
   </div>
{{ Form::submit('submit', ['class' => 'btn btn-primary']) }}     
{!! Form::close() !!}
    
@endsection