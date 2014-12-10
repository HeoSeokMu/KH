  //책 신청
    function bookR() {
    	
        var Input = document.bookRequest;
        
        if(Input.book_title.value == "") {
            alert("책 제목을 입력하세요");
            Input.book_title.focus();
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
        if(Input.id.value == "") {
            alert("학번이 없습니다");
            Input.id.focus();
            return false;
        }
        if(Input.name.value == "") {
            alert("이름을 입력하세요");
            Input.name.focus();
            return false;
        }
        if(Input.s_phone.value == "") {
            alert("전화번호를 입력하세요");
            Input.s_phone.focus();
            return false;
        }
      
        document.bookRequest.action = 'bookRequestPro.kh';
        document.bookRequest.submit();
        
    }
    
