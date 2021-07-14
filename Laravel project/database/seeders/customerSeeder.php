<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\customer;

class customerSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        // array for customers
        $customers = [
            [
            'fname' => 'Ivan',
            'lname' => 'Masaba',
            'email' => 'ivanmasaba@gmail.com',
            'phone' => '0704987574',
            'address' => 'kibuli'
            ],
            [
                'fname' => 'Ivan',
                'lname' => 'Masaba',
                'email' => 'ivanmasaba@gmail.com',
                'phone' => '0704987574',
                'address' => 'kibuli'
            ],
            [
                'fname' => 'Vanesa',
                'lname' => 'Mutonyi',
                'email' => 'vanesamutonyi@gmail.com',
                'phone' => '0704935574',
                'address' => 'kabalagala'
            ],
            [
                'fname' => 'Andrew',
                'lname' => 'Mukasa',
                'email' => 'andym@gmail.com',
                'phone' => '0774987674',
                'address' => 'mulago'
            ],
            [
                'fname' => 'Winnie',
                'lname' => 'Ruth',
                'email' => 'rwinnie@yahoo.com',
                'phone' => '0779130976',
                'address' => 'kireka'
            ]
        
            ];
            foreach($customers as $customer){
                customer::create(array(
                    'fname' => $customer['fname'],
                    'lname' => $customer['lname'],
                    'email' => $customer['email'],
                    'phone' => $customer['phone'],
                    'address' => $customer['address']
                ));
            }
    }
}
