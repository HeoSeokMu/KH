<<<<<<< HEAD
�� f u n c t i o n   s e n d A d d r ( z i p c o d e ) {�� 
�� 	�� 
�� 	 v a r   c o d e   =   " a d d r S u m " + z i p c o d e ;�� 
�� 	 v a r   a d d r S u m   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( c o d e ) [ 0 ] . v a l u e ;�� 
�� 
�� 	 v a r   a d d r   =   a d d r S u m . s p l i t ( " , " ) ;�� 
�� 	 v a r   z i p c o d e   =   a d d r [ 0 ] . s p l i t ( " - " ) ;�� 
�� 	�� 
�� 	 i f ( l o c a t i o n . h r e f   = =   ' h t t p : / / l o c a l h o s t : 8 0 0 0 / K H _ S c h o o l / s e a r c h A d d r P r o . k h ? p a r e n t ' ) {�� 
�� 	 	 o p e n e r . u s e r _ i n p u t . p _ a d d r 1 . v a l u e   =   a d d r [ 1 ] ;�� 
�� 	 	 o p e n e r . u s e r _ i n p u t . p _ z i p c o d e 1 . v a l u e   =   z i p c o d e [ 0 ] ;�� 
�� 	 	 o p e n e r . u s e r _ i n p u t . p _ z i p c o d e 2 . v a l u e   =   z i p c o d e [ 1 ] ;�� 
�� 	 	�� 
�� 	 	 o p e n e r . u s e r _ i n p u t . p _ p o s t . v a l u e   =   z i p c o d e [ 0 ]   +   " - "   +   z i p c o d e [ 1 ] ;�� 
�� 	 	�� 
�� 	 	 w i n d o w . c l o s e ( ) ;�� 
�� 	 } e l s e {�� 
�� 	�� 
�� 	 o p e n e r . u s e r _ i n p u t . a d d r 1 . v a l u e   =   a d d r [ 1 ] ;�� 
�� 	 o p e n e r . u s e r _ i n p u t . z i p c o d e 1 . v a l u e   =   z i p c o d e [ 0 ] ;�� 
�� 	 o p e n e r . u s e r _ i n p u t . z i p c o d e 2 . v a l u e   =   z i p c o d e [ 1 ] ;�� 
�� 	�� 
�� 	 o p e n e r . u s e r _ i n p u t . p o s t . v a l u e   =   z i p c o d e [ 0 ]   +   " - "   +   z i p c o d e [ 1 ] ;�� 
�� 	�� 
�� 	 w i n d o w . c l o s e ( ) ;�� 
�� 	 	 }�� 
�� }�� 
�� 
�� f u n c t i o n   g o S e a r c h ( ) {�� 
�� 	 i f ( l o c a t i o n . h r e f   = =   ' h t t p : / / l o c a l h o s t : 8 0 0 0 / K H _ S c h o o l / s e a r c h A d d r . k h ? p a r e n t ' | |�� 
�� 	 	 	 l o c a t i o n . h r e f   = =   ' h t t p : / / l o c a l h o s t : 8 0 0 0 / K H _ S c h o o l / s e a r c h A d d r P r o . k h ? p a r e n t ' ) {�� 
�� 	 d o c u m e n t . j u s o _ i n p u t . a c t i o n   =   ' s e a r c h A d d r P r o . k h ? p a r e n t ' ;�� 
�� 	 d o c u m e n t . j u s o _ i n p u t . s u b m i t ( ) ;�� 
�� 	 } e l s e {�� 
�� 	 d o c u m e n t . j u s o _ i n p u t . a c t i o n   =   ' s e a r c h A d d r P r o . k h ' ;�� 
�� 	 d o c u m e n t . j u s o _ i n p u t . s u b m i t ( ) ;�� 
�� 	 }�� 
�� }
=======
�� f u n c t i o n   s e n d A d d r ( z i p c o d e ) {  
 	  
 	 v a r   c o d e   =   " a d d r S u m " + z i p c o d e ;  
 	 v a r   a d d r S u m   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( c o d e ) [ 0 ] . v a l u e ;  
  
 	 v a r   a d d r   =   a d d r S u m . s p l i t ( " , " ) ;  
 	 v a r   z i p c o d e   =   a d d r [ 0 ] . s p l i t ( " - " ) ;  
 	  
 	 i f ( l o c a t i o n . h r e f   = =   ' h t t p : / / l o c a l h o s t : 8 0 0 0 / K H _ S c h o o l / s e a r c h A d d r P r o . k h ? p a r e n t ' ) {  
 	 	 o p e n e r . u s e r _ i n p u t . p _ a d d r 1 . v a l u e   =   a d d r [ 1 ] ;  
 	 	 o p e n e r . u s e r _ i n p u t . p _ z i p c o d e 1 . v a l u e   =   z i p c o d e [ 0 ] ;  
 	 	 o p e n e r . u s e r _ i n p u t . p _ z i p c o d e 2 . v a l u e   =   z i p c o d e [ 1 ] ;  
 	 	  
 	 	 o p e n e r . u s e r _ i n p u t . p _ p o s t . v a l u e   =   z i p c o d e [ 0 ]   +   " - "   +   z i p c o d e [ 1 ] ;  
 	 	  
 	 	 w i n d o w . c l o s e ( ) ;  
 	 } e l s e {  
 	  
 	 o p e n e r . u s e r _ i n p u t . a d d r 1 . v a l u e   =   a d d r [ 1 ] ;  
 	 o p e n e r . u s e r _ i n p u t . z i p c o d e 1 . v a l u e   =   z i p c o d e [ 0 ] ;  
 	 o p e n e r . u s e r _ i n p u t . z i p c o d e 2 . v a l u e   =   z i p c o d e [ 1 ] ;  
 	  
 	 o p e n e r . u s e r _ i n p u t . p o s t . v a l u e   =   z i p c o d e [ 0 ]   +   " - "   +   z i p c o d e [ 1 ] ;  
 	  
 	 w i n d o w . c l o s e ( ) ;  
 	 	 }  
 }  
  
 f u n c t i o n   g o S e a r c h ( ) {  
 	 i f ( l o c a t i o n . h r e f   = =   ' h t t p : / / l o c a l h o s t : 8 0 0 0 / K H _ S c h o o l / s e a r c h A d d r . k h ? p a r e n t ' | |  
 	 	 	 l o c a t i o n . h r e f   = =   ' h t t p : / / l o c a l h o s t : 8 0 0 0 / K H _ S c h o o l / s e a r c h A d d r P r o . k h ? p a r e n t ' ) {  
 	 d o c u m e n t . j u s o _ i n p u t . a c t i o n   =   ' s e a r c h A d d r P r o . k h ? p a r e n t ' ;  
 	 d o c u m e n t . j u s o _ i n p u t . s u b m i t ( ) ;  
 	 } e l s e {  
 	 d o c u m e n t . j u s o _ i n p u t . a c t i o n   =   ' s e a r c h A d d r P r o . k h ' ;  
 	 d o c u m e n t . j u s o _ i n p u t . s u b m i t ( ) ;  
 	 }  
 }
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
