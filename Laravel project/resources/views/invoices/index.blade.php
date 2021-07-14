@extends('layouts.app')

@section('content')
 <h1>Invoices</h1>
 <nav>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/invoices/create">Create Invoice</a></li>
      </ul> 
 </nav>

 <div class="container mt-5">
    <table class="table mt-3"> 
        <thead>
             <tr> 
                 <th scope="col">Date</th>
                  <th scope="col">Customer</th> 
                  <th scope="col">Product</th> 
                 </tr> 
             </thead>
              <tbody>
                   @foreach ($invoices as $invoice) 
                   <tr>
                        <td>{{ $invoice->date }}</td>
                      <td>{{ $invoice->customer }}</td>
                       <td>{{ $invoice->product }}</td>  
                       <td><a href="/invoices/{{ $invoice->id }}/edit" class="btn btn-sm btn-success">Edit</a>
                        <td>
                         {!! Form::open(['action' => ['App\Http\Controllers\InvoiceController@destroy', $invoice->id], 'class' => 'pull-right']) !!}
                         @csrf
                         {{ Form::submit('Delete', ['class' => 'btn btn-danger']) }}
                         {{ Form::hidden('_method', 'DELETE') }}
                         {!! Form::close() !!}  
                     </td>
                      </tr>
                       @endforeach 
                       {{ $invoices->links() }}
                     </tbody>
                  </table>
                     
             </div>


@endsection