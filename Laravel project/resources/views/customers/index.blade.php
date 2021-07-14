@extends('layouts.app')

@section('content')
 <h2>Customers</h2>
 <nav>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/customers/create">Create Customer</a></li>
      </ul> 
 </nav>    

 <div class="container mt-5">
       <table class="table mt-3"> 
           <thead>
                <tr> 
                    <th scope="col">First Name</th>
                     <th scope="col">Last Name</th> 
                     <th scope="col">Email</th> 
                     <th scope="col">Phone</th>
                      <th scope="col">Address</th> 
                    </tr> 
                </thead>
                 <tbody>
                      @foreach ($customers as $customer) 
                      <tr>
                           <td>{{ $customer->fname }}</td>
                         <td>{{ $customer->lname }}</td>
                          <td>{{ $customer->email }}</td> 
                          <td>{{ $customer->phone }}</td> 
                          <td>{{ $customer->address }}</td> 
                          <td><a href="/customers/{{ $customer->id }}/edit" class="btn btn-sm btn-success">Edit</a>
                           <td>
                            {!! Form::open(['action' => ['App\Http\Controllers\CustomerController@destroy', $customer->id], 'class' => 'pull-right']) !!}
                            @csrf
                            {{ Form::submit('Delete', ['class' => 'btn btn-danger']) }}
                            {{ Form::hidden('_method', 'DELETE') }}
                            {!! Form::close() !!}  
                        </td>
                         </tr>
                          @endforeach 
                          {{ $customers->links() }}
                        </tbody>
                     </table>
                        
                </div>

@endsection