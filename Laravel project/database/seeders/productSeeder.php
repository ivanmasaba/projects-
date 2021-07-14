<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\product;

class productSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
         // array for customers
         $products = [
            [
            'pname' => 'milk',
            'price' => '1400',
            'description' => 'drink',
            'service' => 0
            ],
            ['pname' => 'car',
            'price' => '20000',
            'description' => 'taxi',
            'service' => 1
            ],
            [
            'pname' => 'rice',
            'price' => '1500',
            'description' => 'food',
            'service' => 0
            ],
            [
                'pname' => 'maize',
                'price' => '1800',
                'description' => 'food',
                'service' => 0
            ],
            [
                'pname' => 'book',
                'price' => '2000',
                'description' => 'scolarstic',
                'service' => 0
            ]
        
            ];
            foreach($products as $product){
                product::create(array(
                    'pname' => $product['pname'],
                    'price' => $product['price'],
                    'description' => $product['description'],
                    'service' => $product['service']
                ));
            }
    }
}
