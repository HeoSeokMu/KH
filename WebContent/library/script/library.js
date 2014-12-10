// 폼 유효성 검사 후 submit.    
    function enter() {
    	
        var Input = document.bookInsert;
        
        if(Input.book_title.value == "") {
            alert("책 제목을 입력하세요");
            Input.book_title.focus();
            return false;
        
 
                }
        
        if(Input.book_location.value == "") {
            alert("책 위치를 입력하세요");
            Input.book_location.focus();
            return false;
         }
        if(Input.book_writer.value == "") {
            alert("저자를 입력하세요");
            Input.book_writer.focus();
            return false;
        }
        if(Input.book_publisher.value == "") {
            alert("출판사를 입력하세요");
            Input.book_publisher.focus();
            return false;
        }
        if(Input.book_year.value == "") {
            alert("출판년도를 입력하세요");
            Input.book_year.focus();
            return false;
        
        }else{
        	var engnum_check = /^[0-9]+$/;
        	if(engnum_check.test(Input.book_year.value)){
        	}else{
        		alert("출판년도는 숫자만 입력할 수 있습니다");
        		Input.book_year.value = "";
    			Input.book_year.focus();
    			return false;
        	}
       
        }
        if(Input.book_supplement.value == "") {
            alert("부록을 입력하세요");
            Input.book_supplement.focus();
            return false;
        }
        if(Input.isbn.value == "") {
            alert("isbn을 입력하세요");
            Input.isbn.focus();
            return false;
        
        }else{
        	var engnum_check = /^[0-9]+$/;
        	if(engnum_check.test(Input.isbn.value)){
        	}else{
        		alert("isbn은 숫자만 입력할 수 있습니다");
        		Input.isbn.value = "";
    			Input.isbn.focus();
    			return false;
        	}
       
        }
        if(Input.upload.value == "") {
            alert("책 이미지를 넣어주세요");
            Input.upload.focus();
            return false;
        }
      
        document.bookInsert.action = 'bookInsertFormPro.kh';
        document.bookInsert.submit();
        
    }
    
