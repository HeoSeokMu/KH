<<<<<<< HEAD
�� 
�� $ ( d o c u m e n t ) . r e a d y ( f u n c t i o n ( )   {�� 
�� 
�� 	 $ ( ' # u p l o a d ' ) . c h a n g e ( f u n c t i o n ( e v t )   {�� 
�� 
�� 	           v a r   f i l e s   =   e v t . t a r g e t . f i l e s ;  �� 
�� 
�� 
�� 	           v a r   r e a d e r   =   n e w   F i l e R e a d e r ( ) ;�� 
�� 
�� 	           r e a d e r . o n l o a d   =   ( f u n c t i o n ( t h e F i l e )   {�� 
�� 
�� 	         	   r e t u r n   f u n c t i o n ( e )   {�� 
�� 
�� 	         	 	   $ ( ' # p r e V i e w ' ) . a t t r ( ' s r c ' , e . t a r g e t . r e s u l t ) ;�� 
�� 
�� 	         	   } ;  �� 
�� 
�� 	           } ) ( f i l e s [ 0 ] ) ;�� 
�� 
�� 
�� 	           r e a d e r . r e a d A s D a t a U R L ( f i l e s [ 0 ] ) ;�� 
�� 
�� 	 } ) ;�� 
�� 
�� } ) ;�� 
�� 
��        �� 
��         f u n c t i o n   e n t e r ( )   {�� 
��         	�� 
��                 v a r   I n p u t   =   d o c u m e n t . u s e r _ i n p u t ;�� 
��                �� 
��                 i f ( I n p u t . n u m . v a l u e   = =   " " )   {�� 
��                         a l e r t ( "���8�|  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                 i f ( I n p u t . p a s s w o r d . v a l u e   = =   " " )   {�� 
��                         a l e r t ( "�D� ���8�|  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                 i f ( I n p u t . p a s s w o r d . v a l u e   ! =   I n p u t . p a s s w o r d _ r e . v a l u e )�� 
��                 {�� 
��                         a l e r t ( "�D� ���8�|  ���|�X��  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                 i f ( I n p u t . n a m e . v a l u e   = =   " " )   {�� 
��                         a l e r t ( "�t���D  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                 i f ( I n p u t . s e x . v a l u e   = =   " " )   {�� 
��                         a l e r t ( "�1���D  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                 i f ( I n p u t . b i r t h _ y y . v a l u e   = =   " "   | |   I n p u t . b i r t h _ m m . v a l u e   = =   " "   | |   I n p u t . b i r t h _ d d . v a l u e   = =   " " )   {�� 
��                         a l e r t ( "�ݱD���|�D  ǅ�%�t���8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                 i f ( I n p u t . m a j o r . v a l u e   = =   " " )   {�� 
��                         a l e r t ( "����D  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                 i f ( I n p u t . b e f o r e _ s c h o o l . v a l u e   = =   " " )   {�� 
��                         a l e r t ( "͜���Y�P�|  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                 i f ( I n p u t . a d d r e s s . v a l u e   = =   " " )   {�� 
��                         a l e r t ( "�����|  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                       	�� 
��                 i f ( I n p u t . p h o n e 1 . v a l u e   = =   " "   | |   I n p u t . p h o n e 2 . v a l u e   = =   " " ) {�� 
��                         a l e r t ( "��}̘�|  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                 i f ( I n p u t . a d d r 1 . v a l u e   = =   " "   | |   I n p u t . a d d r 2 . v a l u e   = =   " " ) {�� 
��                         a l e r t ( "�����|  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
��                 i f ( I n p u t . e _ m a i l . v a l u e   = =   " " ) {�� 
��                         a l e r t ( "�T�|�����|  ǅ�%�X�8Ɣ " ) ;�� 
��                         r e t u r n   f a l s e ;�� 
��                 }�� 
�� 
��                 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' j o i n F o r m P r o . k h ' ;�� 
��                 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;�� 
��                �� 
��         }�� 
��      �� 
��                        �� 
��         f u n c t i o n   d e l p i c ( ) {�� 
��         	 d o c u m e n t . u s e r _ i n p u t . u p l o a d . o u t e r H T M L   =   d o c u m e n t . u s e r _ i n p u t . u p l o a d . o u t e r H T M L ;�� 
��         }�� 
��        �� 
�� 
�� 
�� 	 f u n c t i o n   e _ m a i l _ E V E N T ( e _ m a i l )   {�� 
�� 	 	 i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 0 ] . s e l e c t e d )   {�� 
�� 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 0 ] . v a l u e ;�� 
�� 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 1 ] . s e l e c t e d )   {�� 
�� 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 1 ] . v a l u e ;�� 
�� 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 2 ] . s e l e c t e d )   {�� 
�� 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 2 ] . v a l u e ;�� 
�� 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 3 ] . s e l e c t e d )   {�� 
�� 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 3 ] . v a l u e ;�� 
�� 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 4 ] . s e l e c t e d )   {�� 
�� 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 4 ] . v a l u e ;�� 
�� 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 5 ] . s e l e c t e d )   {�� 
�� 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 5 ] . v a l u e ;�� 
�� 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 6 ] . s e l e c t e d )   {�� 
�� 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 6 ] . v a l u e ;�� 
�� 	 	 }�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   P o s t _ C H E C K ( p o s t ) {�� 
�� 	 	 p o s t . p o s t . v a l u e   =   p o s t . z i p c o d e 1 . v a l u e   +   p o s t . z i p c o d e 2 . v a l u e ;�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   A d d r e s s _ C H E C K ( a d d r )   {�� 
�� 	 	 a d d r . a d d r e s s . v a l u e   =   a d d r . a d d r 1 . v a l u e   +   a d d r . a d d r 2 . v a l u e ;�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   e m a i l _ s u m ( )   {�� 
�� 	 	�� 
�� 	 	 v a r   o b j 1   =   d o c u m e n t . u s e r _ i n p u t . e _ m a i l ;�� 
�� 	 	 v a r   o b j 2   =   d o c u m e n t . u s e r _ i n p u t . m a i l ;�� 
�� 	 	 v a r   o b j 3   =   d o c u m e n t . u s e r _ i n p u t . m a i l _ a d d r e s s ;�� 
�� 	 	�� 
�� 	 	 o b j 1 . v a l u e   =   o b j 2 . v a l u e   +   o b j 3 . v a l u e ;�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   p h o n e _ C H E C K ( p h o n e )   {�� 
�� 	 	 p h o n e . s _ p h o n e . v a l u e   =   " [ " + p h o n e . t e l _ s e l . v a l u e + " ] " + p h o n e . p h o n e _ n u m b e r _ s e l . v a l u e   + " - " +   p h o n e . p h o n e 1 . v a l u e   + " - " +   p h o n e . p h o n e 2 . v a l u e ;�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   p _ p h o n e _ C H E C K ( p _ p h o n e )   {�� 
�� 	 	 p _ p h o n e . p _ p h o n e . v a l u e   =   " [ " + p _ p h o n e . p _ t e l _ s e l . v a l u e + " ] " + p _ p h o n e . p _ p h o n e _ n u m b e r _ s e l . v a l u e   + " - " +   p _ p h o n e . p _ p h o n e 1 . v a l u e   + " - " +   p _ p h o n e . p _ p h o n e 2 . v a l u e ;�� 
�� 	 }�� 
�� 
�� 	 f u n c t i o n   h i d e D e f a u l t P i c ( ) {�� 
�� 
�� 	 	 v a r   i   =   d o c u m e n t . g e t E l e m e n t B y I d ( " d e f _ i m g " ) ;�� 
�� 
�� 	 	 i . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 
�� 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " p r e _ d i v " ) . s t y l e . d i s p l a y   =   ' ' ;�� 
�� 
�� 	 }�� 
�� 
�� 
�� f u n c t i o n   c o v e r P i c ( ) {�� 
�� 	 v a r   i   =   d o c u m e n t . g e t E l e m e n t B y I d ( " d e f _ i m g " ) ;�� 
�� 	 i . s t y l e . d i s p l a y   =   ' b l o c k ' ;�� 
�� 	 d o c u m e n t . g e t E l e m e n t B y I d ( " p r e _ d i v " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� }�� 
�� 
�� f u n c t i o n   s t u d e n t ( ) {�� 
�� 	 d o c u m e n t . g e t E l e m e n t B y I d ( " e m p " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 d o c u m e n t . g e t E l e m e n t B y I d ( " s t u " ) . s t y l e . d i s p l a y   =   ' b l o c k ' ;�� 
�� 	�� 
�� 	 d o c u m e n t . g e t E l e m e n t B y I d ( " w o r k " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 d o c u m e n t . g e t E l e m e n t B y I d ( " m a j " ) . s t y l e . d i s p l a y   =   ' b l o c k ' ;�� 
�� }�� 
�� 
�� f u n c t i o n   e m p l o ( ) {�� 
�� 	 d o c u m e n t . g e t E l e m e n t B y I d ( " e m p " ) . s t y l e . d i s p l a y   =   ' b l o c k ' ;�� 
�� 	 d o c u m e n t . g e t E l e m e n t B y I d ( " s t u " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	�� 
�� 	 d o c u m e n t . g e t E l e m e n t B y I d ( " w o r k " ) . s t y l e . d i s p l a y   =   ' b l o c k ' ;�� 
�� 	 d o c u m e n t . g e t E l e m e n t B y I d ( " m a j " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� }
=======
��  
 $ ( d o c u m e n t ) . r e a d y ( f u n c t i o n ( )   {  
  
 	 $ ( ' # u p l o a d ' ) . c h a n g e ( f u n c t i o n ( e v t )   {  
  
 	           v a r   f i l e s   =   e v t . t a r g e t . f i l e s ;    
  
  
 	           v a r   r e a d e r   =   n e w   F i l e R e a d e r ( ) ;  
  
 	           r e a d e r . o n l o a d   =   ( f u n c t i o n ( t h e F i l e )   {  
  
 	         	   r e t u r n   f u n c t i o n ( e )   {  
  
 	         	 	   $ ( ' # p r e V i e w ' ) . a t t r ( ' s r c ' , e . t a r g e t . r e s u l t ) ;  
  
 	         	   } ;    
  
 	           } ) ( f i l e s [ 0 ] ) ;  
  
  
 	           r e a d e r . r e a d A s D a t a U R L ( f i l e s [ 0 ] ) ;  
  
 	 } ) ;  
  
 } ) ;  
  
          
         f u n c t i o n   e n t e r ( )   {  
         	  
                 v a r   I n p u t   =   d o c u m e n t . u s e r _ i n p u t ;  
                  
                 i f ( I n p u t . n u m . v a l u e   = =   " " )   {  
                         a l e r t ( "���8�|  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 i f ( I n p u t . p a s s w o r d . v a l u e   = =   " " )   {  
                         a l e r t ( "�D� ���8�|  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 i f ( I n p u t . p a s s w o r d . v a l u e   ! =   I n p u t . p a s s w o r d _ r e . v a l u e )  
                 {  
                         a l e r t ( "�D� ���8�|  ���|�X��  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 i f ( I n p u t . n a m e . v a l u e   = =   " " )   {  
                         a l e r t ( "�t���D  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 i f ( I n p u t . s e x . v a l u e   = =   " " )   {  
                         a l e r t ( "�1���D  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 i f ( I n p u t . b i r t h _ y y . v a l u e   = =   " "   | |   I n p u t . b i r t h _ m m . v a l u e   = =   " "   | |   I n p u t . b i r t h _ d d . v a l u e   = =   " " )   {  
                         a l e r t ( "�ݱD���|�D  ǅ�%�t���8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 i f ( I n p u t . m a j o r . v a l u e   = =   " " )   {  
                         a l e r t ( "����D  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 i f ( I n p u t . b e f o r e _ s c h o o l . v a l u e   = =   " " )   {  
                         a l e r t ( "͜���Y�P�|  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 i f ( I n p u t . a d d r e s s . v a l u e   = =   " " )   {  
                         a l e r t ( "�����|  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                       	  
                 i f ( I n p u t . p h o n e 1 . v a l u e   = =   " "   | |   I n p u t . p h o n e 2 . v a l u e   = =   " " ) {  
                         a l e r t ( "��}̘�|  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 i f ( I n p u t . a d d r 1 . v a l u e   = =   " "   | |   I n p u t . a d d r 2 . v a l u e   = =   " " ) {  
                         a l e r t ( "�����|  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
                 i f ( I n p u t . e _ m a i l . v a l u e   = =   " " ) {  
                         a l e r t ( "�T�|�����|  ǅ�%�X�8Ɣ " ) ;  
                         r e t u r n   f a l s e ;  
                 }  
  
                 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' j o i n F o r m P r o . k h ' ;  
                 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;  
                  
         }  
        
                          
         f u n c t i o n   d e l p i c ( ) {  
         	 d o c u m e n t . u s e r _ i n p u t . u p l o a d . o u t e r H T M L   =   d o c u m e n t . u s e r _ i n p u t . u p l o a d . o u t e r H T M L ;  
         }  
          
  
  
 	 f u n c t i o n   e _ m a i l _ E V E N T ( e _ m a i l )   {  
 	 	 i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 0 ] . s e l e c t e d )   {  
 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 0 ] . v a l u e ;  
 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 1 ] . s e l e c t e d )   {  
 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 1 ] . v a l u e ;  
 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 2 ] . s e l e c t e d )   {  
 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 2 ] . v a l u e ;  
 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 3 ] . s e l e c t e d )   {  
 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 3 ] . v a l u e ;  
 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 4 ] . s e l e c t e d )   {  
 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 4 ] . v a l u e ;  
 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 5 ] . s e l e c t e d )   {  
 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 5 ] . v a l u e ;  
 	 	 }   e l s e   i f ( e _ m a i l . m a i l _ s e l . o p t i o n s [ 6 ] . s e l e c t e d )   {  
 	 	 	 e _ m a i l . m a i l _ a d d r e s s . v a l u e   =   e _ m a i l . m a i l _ s e l . o p t i o n s [ 6 ] . v a l u e ;  
 	 	 }  
 	 }  
 	  
 	 f u n c t i o n   P o s t _ C H E C K ( p o s t ) {  
 	 	 p o s t . p o s t . v a l u e   =   p o s t . z i p c o d e 1 . v a l u e   +   p o s t . z i p c o d e 2 . v a l u e ;  
 	 }  
 	  
 	 f u n c t i o n   A d d r e s s _ C H E C K ( a d d r )   {  
 	 	 a d d r . a d d r e s s . v a l u e   =   a d d r . a d d r 1 . v a l u e   +   a d d r . a d d r 2 . v a l u e ;  
 	 }  
 	  
 	 f u n c t i o n   e m a i l _ s u m ( )   {  
 	 	  
 	 	 v a r   o b j 1   =   d o c u m e n t . u s e r _ i n p u t . e _ m a i l ;  
 	 	 v a r   o b j 2   =   d o c u m e n t . u s e r _ i n p u t . m a i l ;  
 	 	 v a r   o b j 3   =   d o c u m e n t . u s e r _ i n p u t . m a i l _ a d d r e s s ;  
 	 	  
 	 	 o b j 1 . v a l u e   =   o b j 2 . v a l u e   +   o b j 3 . v a l u e ;  
 	 }  
 	  
 	 f u n c t i o n   p h o n e _ C H E C K ( p h o n e )   {  
 	 	 p h o n e . s _ p h o n e . v a l u e   =   " [ " + p h o n e . t e l _ s e l . v a l u e + " ] " + p h o n e . p h o n e _ n u m b e r _ s e l . v a l u e   + " - " +   p h o n e . p h o n e 1 . v a l u e   + " - " +   p h o n e . p h o n e 2 . v a l u e ;  
 	 }  
 	  
 	 f u n c t i o n   p _ p h o n e _ C H E C K ( p _ p h o n e )   {  
 	 	 p _ p h o n e . p _ p h o n e . v a l u e   =   " [ " + p _ p h o n e . p _ t e l _ s e l . v a l u e + " ] " + p _ p h o n e . p _ p h o n e _ n u m b e r _ s e l . v a l u e   + " - " +   p _ p h o n e . p _ p h o n e 1 . v a l u e   + " - " +   p _ p h o n e . p _ p h o n e 2 . v a l u e ;  
 	 }  
  
 	 f u n c t i o n   h i d e D e f a u l t P i c ( ) {  
  
 	 	 v a r   i   =   d o c u m e n t . g e t E l e m e n t B y I d ( " d e f _ i m g " ) ;  
  
 	 	 i . s t y l e . d i s p l a y   =   ' n o n e ' ;  
  
 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " p r e _ d i v " ) . s t y l e . d i s p l a y   =   ' ' ;  
  
 	 }  
  
  
 f u n c t i o n   c o v e r P i c ( ) {  
 	 v a r   i   =   d o c u m e n t . g e t E l e m e n t B y I d ( " d e f _ i m g " ) ;  
 	 i . s t y l e . d i s p l a y   =   ' b l o c k ' ;  
 	 d o c u m e n t . g e t E l e m e n t B y I d ( " p r e _ d i v " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 }  
  
 f u n c t i o n   s t u d e n t ( ) {  
 	 d o c u m e n t . g e t E l e m e n t B y I d ( " e m p " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 d o c u m e n t . g e t E l e m e n t B y I d ( " s t u " ) . s t y l e . d i s p l a y   =   ' b l o c k ' ;  
 	  
 	 d o c u m e n t . g e t E l e m e n t B y I d ( " w o r k " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 d o c u m e n t . g e t E l e m e n t B y I d ( " m a j " ) . s t y l e . d i s p l a y   =   ' b l o c k ' ;  
 }  
  
 f u n c t i o n   e m p l o ( ) {  
 	 d o c u m e n t . g e t E l e m e n t B y I d ( " e m p " ) . s t y l e . d i s p l a y   =   ' b l o c k ' ;  
 	 d o c u m e n t . g e t E l e m e n t B y I d ( " s t u " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	  
 	 d o c u m e n t . g e t E l e m e n t B y I d ( " w o r k " ) . s t y l e . d i s p l a y   =   ' b l o c k ' ;  
 	 d o c u m e n t . g e t E l e m e n t B y I d ( " m a j " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 }
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
