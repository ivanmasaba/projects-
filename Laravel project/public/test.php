<?php
     
      $con = new PDO('oci:dbname=localhost/orcl;','system','Heaven4*4');

   if(!$con){
           echo "ERROR:   CONNECTION TO ORACLE FAILED.?????";
       }else{
         
      echo "CONNECTION TO ORACLE WAS SUCCESSFUL...";
         }



?>