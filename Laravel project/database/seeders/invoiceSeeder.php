<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\invoice;

class invoiceSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
         // array for customers
         $invoices = [
            [
            'date' => '2021-01-20',
            'customer' => 'Masaba',
            'product' => 'milk'
            ],
            [
                'date' => '2021-01-22',
                'customer' => 'Vanesa',
                'product' => 'rice'
            ],
            [
            'date' => '2021-02-02',
            'customer' => 'Andrew',
            'product' => 'car'
            ],
            [
            'date' => '2021-02-08',
            'customer' => 'Winnie',
            'product' => 'milk'
            ],
            [
            'date' => '2021-03-20',
            'customer' => 'Masaba',
            'product' => 'car'
            ]
        
            ];
            foreach($invoices as $invoice){
                invoice::create(array(
                    'date' => $invoice['date'],
                    'customer' => $invoice['customer'],
                    'product' => $invoice['product']
                ));
            }
    }
}
