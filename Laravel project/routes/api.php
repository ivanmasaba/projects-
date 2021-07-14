<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\CustomersController;
use App\Http\Controllers\InvoicesController;
use App\Http\Controllers\ProductsController;
use App\Http\Controllers\PagesController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

//index page
Route::get('/', [PagesController::class, 'index']);

// display records
Route::get('/customers', [CustomersController::class, 'index']);

Route::get('/products', [ProductsController::class, 'index']);

Route::get('/invoices', [InvoicesController::class, 'index']);

// display a single records
Route::get('/customers/{id}', [CustomersController::class, 'show']);

Route::get('/products/{id}', [ProductsController::class, 'show']);

Route::get('/invoices/{id}', [InvoicesController::class, 'show']);

// insert data into tables
Route::post('/customers', [CustomersController::class, 'store']);

Route::post('/products', [ProductsController::class, 'store']);

Route::post('/invoices', [InvoicesController::class, 'store']);

// update records

Route::put('/customers/{id}', [CustomersController::class, 'update']);

Route::put('/products/{id}', [ProductsController::class, 'update']);

Route::put('/invoices/{id}', [InvoicesController::class, 'update']);

//delete a record

Route::delete('/customers/{id}', [CustomersController::class, 'destroy']);

Route::delete('/products/{id}', [ProductsController::class, 'destroy']);

 Route::delete('/invoices/{id}', [InvoicesController::class, 'destroy']);