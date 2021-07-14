@extends('layouts.app')

@section('content')
 <h1>Products</h1>

 <nav>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/products/create">Create Product</a></li>
      </ul> 
 </nav>
 <div class="container mt-5">
    <table class="table mt-3"> 
        <thead>
             <tr> 
                 <th scope="col">Product Nmae</th>
                  <th scope="col">Price</th> 
                  <th scope="col">Description</th> 
                  <th scope="col">Service</th>
                 </tr> 
             </thead>
              <tbody>
                   @foreach ($products as $product) 
                   <tr>
                        <td>{{ $product->pname }}</td>
                      <td>{{ $product->price }}</td>
                       <td>{{ $product->description }}</td> 
                       <td>
                        @if (($product->service) == 0)
                          {{ 'false' }}
                          @else
                           {{ 'true' }}
                        @endif 
                      </td> 
                       <td><a href="/products/{{ $product->id }}/edit" class="btn btn-sm btn-success">Edit</a>
                        <td>
                         {!! Form::open(['action' => ['App\Http\Controllers\ProductController@destroy', $product->id], 'class' => 'pull-right']) !!}
                         @csrf
                         {{ Form::submit('Delete', ['class' => 'btn btn-danger']) }}
                         {{ Form::hidden('_method', 'DELETE') }}
                         {!! Form::close() !!}  
                     </td>
                      </tr>
                       @endforeach 
                       {{ $products->links() }}
                     </tbody>
                  </table>
                     
             </div> 
@endsection