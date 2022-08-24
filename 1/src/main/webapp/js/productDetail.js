/**
 * 
 */

function quanPlus(current){
	let quanVal = document.querySelector(".quanInput");
	if(isNaN(parseInt(quanVal.value))){
		quanVal.value = parseInt(0);
	}
	
	quanVal.value = parseInt(quanVal.value) +  parseInt(current);
	
	if(parseInt(quanVal.value) < 1){
		quanVal.value = parseInt(1);
	}
}

function quanCount(){
	let quanVal = document.querySelector(".quanInput");
	if(isNaN(parseInt(quanVal.value))){
		quanVal.value = parseInt(1);
	}
	quanVal.value = quanVal.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
}

function test(){
	let quanVal = document.querySelector(".quanInput");
	console.log(quanVal.value);
}














