<<<<<<< HEAD
�� 
�� 
�� 	 f u n c t i o n   b o d y ( ) {�� 
�� 	 	 a l e r t ( " b o d y " ) ;�� 
�� 	 	�� 
�� 	 	 v a r   h i d e   =   d o c u m e n t . g e t E l e m e n t B y I d ( " t y p e B " ) ;   / /  �Pő  ��  �(�@ ( d e f a u l t )�� 
�� 	 	 h i d e . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 	�� 
�� 	 / *   	 v a r   c   =   d o c u m e n t . g e t E l e m e n t B y I d ( " 1 0 1 " ) ;�� 
�� 	 	 c . s t y l e . b a c k g r o u n d C o l o r = " b l u e " ;   * /�� 
�� 	�� 
�� 	 	 f o r ( v a r   i = 0 ;   i < = 9 ;   i + + ) {�� 
�� 	 	 	 v a r   t y p e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ t y p e " ) [ i ] . v a l u e ;�� 
�� 	 	 	 v a r   c o d e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ c o d e " ) [ i ] . v a l u e ;�� 
�� 	 	 	 v a r   t a b l e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ t a b l e " ) [ i ] . v a l u e ;�� 
�� 	 	 	 v a r   n a m e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ n a m e " ) [ i ] . v a l u e ;�� 
�� 	 	 	 v a r   h a k j u m   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ h a k j u m " ) [ i ] . v a l u e ;�� 
�� 	 	 	 v a r   p r o f e s s o r   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ p r o f e s s o r " ) [ i ] . v a l u e ;�� 
�� 	 	 	�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s e t _ s c h " + i ) [ 0 ] . v a l u e   =   t y p e ;�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( i ) [ 0 ] . v a l u e   =   n a m e ;   / *����  �t�� * /�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " c o d e " + i ) [ 0 ] . v a l u e   =   c o d e ;�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " t a b l e " + i ) [ 0 ] . v a l u e   =   t a b l e ;�� 
�� 	 	 	�� 
�� 	 	 	 i f ( t y p e   = =   " e " ) {�� 
�� 	 	 	 	 t y p e = "�  �D " ;�� 
�� 	 	 	 } e l s e {�� 
�� 	 	 	 	 t y p e = "�  �  " ;�� 
�� 	 	 	 }�� 
�� 	 	 	�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t " + i ) [ 0 ] . v a l u e   =   t y p e ;   / *��  ,  ��D * /�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m " + i ) [ 0 ] . v a l u e   =   h a k j u m ;�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " p r o f e s s o r " + i ) [ 0 ] . v a l u e   =   p r o f e s s o r ;�� 
�� 	 	�� 
�� 	 	 }�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   h a k j u m _ c h e c k ( n u m ,   s c h ) {�� 
�� 	 	�� 
�� 	 	 v a r   s u g a n g   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g " ) ;   / /    �0���\  ���D   . l e n g t h   1���0  ��Ǒ�X�0�L�4��   - 1�� 
�� 	 	 v a r   s i z e   =   s u g a n g . l e n g t h   - 1 ;�� 
�� 
�� 	 	 v a r   h a k j u m _ s u m   =   0 ;       	 	 	 	 / /  �Y�  �g�H�� 
�� 	 	 f o r ( v a r   i = 0 ;   i < = s i z e ;   i + + ) {�� 
�� 	 	 	 v a r   h a k j u m N a m e   =   " h a k j u m " + i ;�� 
�� 	 	 	 v a r   h a k j u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( h a k j u m N a m e ) [ 0 ] . v a l u e ) ;�� 
�� 	 	 	   h a k j u m _ s u m   + =   h a k j u m ; 	�� 
�� 	 	 }�� 
�� 	�� 
�� 	 	 i f ( h a k j u m _ s u m   = =   0 ) {�� 
�� 	 	 	   h a k j u m _ s u m   =   " " ;�� 
�� 	 	 }�� 
�� 	�� 
�� 	 	 l o w l i m i t _ h a k j u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " l o w l i m i t _ h a k j u m " ) [ 0 ] . v a l u e ) ;   / /  �\�   Ɣ�l  �Y��� 
�� 	 	 h i g h l i m i t _ h a k j u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h i g h l i m i t _ h a k j u m " ) [ 0 ] . v a l u e ) ;   / /  �\��  Ɣ�l  �Y��� 
�� 	 	 i f ( h a k j u m _ s u m   >   h i g h l i m i t _ h a k j u m ) {   / /  Ɣ�l  �Y�  �U�x  �  �g�H�� 
�� 	 	 	 a l e r t ( "�\�   �DƔ  �Y��t  ���Ոµ�Ȳ� . " ) ;�� 
�� 	 	 	 n o ( n u m ) ; 	   	 	 	 / /  �Y��t  ���  Ո�D�L  ��̭  ���]���  ǐ��  ��� 	�� 
�� 	 	 } e l s e   i f ( h a k j u m _ s u m   <   l o w l i m i t _ h a k j u m ) {�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m _ s u m " ) [ 0 ] . v a l u e   =   h a k j u m _ s u m ;�� 
�� 	 	 	�� 
�� 	 	 	 i f (   s c h   ! =   n u l l ) {�� 
�� 	 	 	 	 s c h e d u l e ( s c h ) ;�� 
�� 	 	 	 }�� 
�� 	 	 	�� 
�� 	 	 } e l s e {�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m _ s u m " ) [ 0 ] . v a l u e   =   h a k j u m _ s u m ;�� 
�� 	 	 	�� 
�� 	 	 	 i f (   s c h   ! =   n u l l ) {�� 
�� 	 	 	 	 s c h e d u l e ( s c h ) ;�� 
�� 	 	 	 }�� 
�� 	 	 }�� 
�� 	 	 r e t u r n ;�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   o k ( n u m ) {           / /  ��@  �ܬ� ��  ����̭�t  �Ŵǈ����  �U�x�� 
�� 	 	 v a r   n a m e   =   " s c h _ t i m e " + n u m ;�� 
�� 	 	 v a r   s u b j e c t   =   " s u g a n g s u b j e c t " + n u m ;�� 
�� 	 	 v a r   v a l u e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) ;�� 
�� 	 	 v a r   c h e c k   =   0 ;�� 
�� 	 	�� 
�� 	 	 f o r ( v a r   i = 0 ;   i < v a l u e . l e n g t h ;   i + + ) {       	 	 	�� 
�� 	 	 	 v a r   s c h   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) [ i ] . v a l u e ;�� 
�� 	 	 	 v a r   c   =   d o c u m e n t . g e t E l e m e n t B y I d ( s c h ) ;�� 
�� 	 	 	 v a r   c h k   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s c h _ " + s c h ) [ 0 ] . v a l u e ;�� 
�� 	 	 	 i f ( c h k   ! =   " " ) {�� 
�� 	 	 	 	 c h e c k   =   c h e c k + 1 ;�� 
�� 	 	 	 } 	�� 
�� 	 	 }�� 
�� 	 	 i f ( c h e c k   = =   0 ) {�� 
�� 	 	 	 a d d ( n u m ) ;�� 
�� 	 	 } e l s e {�� 
�� 	 	 	 a l e r t ( "��  �ܬ�\�|  �U�x�X�8Ɣ   ! ! " ) ;�� 
�� 	 	 }�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   a d d ( n u m ) {�� 
�� 	 	 v a r   t e x t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g l i s t " ) [ n u m - 1 ] . v a l u e ;   / /  ������ 
�� 	 	 v a r   s u b j e c t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t l i s t " ) [ n u m - 1 ] . v a l u e ;   / /  �l���� 
�� 	 	 v a r   p r o f e s s o r   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " p r o f e s s o r l i s t " ) [ n u m - 1 ] . v a l u e ;   / /  ����  �P��� 
�� 	 	 v a r   h a k j u m   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m l i s t " ) [ n u m - 1 ] . v a l u e ;   / /  �Y��� 
�� 	 	 v a r   c o d e   =     d o c u m e n t . g e t E l e m e n t s B y N a m e ( " l _ c o d e " ) [ n u m - 1 ] . v a l u e ;   / /�����T���� 
�� 	 	 v a r   t a b l e   =     d o c u m e n t . g e t E l e m e n t s B y N a m e ( " t a b l e n a m e " ) [ n u m - 1 ] . v a l u e ;   / /�L�t�  �t���� 
�� 	 	�� 
�� 	 	 v a r   s u g a n g   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g " ) ;   / /    �0���\  ���D   . l e n g t h   1���0  ��Ǒ�X�0�L�4��   - 1�� 
�� 	 	�� 
�� 	 	 f o r ( v a r   i = 0 ;   i < = s u g a n g . l e n g t h ;   i + + ) { 	�� 
�� 	 	 	 v a r   v a l u e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( i ) [ 0 ] . v a l u e ;�� 
�� 	 	 	�� 
�� 	 	 	 i f ( v a l u e   = =   " " ) {�� 
�� 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( i ) [ 0 ] . v a l u e   =   t e x t ;   / /  ����   i n s e r t�� 
�� 	 	 	 	�� 
�� 	 	 	 	 v a r   s u b j e c t N a m e   =   " s u b j e c t " + i ;�� 
�� 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( s u b j e c t N a m e ) [ 0 ] . v a l u e   =   s u b j e c t ;   / /  �l��   i n s e r t�� 
�� 	 	 	 	�� 
�� 	 	 	 	 v a r   p r o f e s s o r N a m e   =   " p r o f e s s o r " + i ;�� 
�� 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( p r o f e s s o r N a m e ) [ 0 ] . v a l u e   =   p r o f e s s o r ;   / /  ����  �P�     i n s e r t�� 
�� 	 	 	 	�� 
�� 	 	 	 	 v a r   h a k j u m N a m e   =   " h a k j u m " + i ;�� 
�� 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( h a k j u m N a m e ) [ 0 ] . v a l u e   =   h a k j u m ;   / /  �Y�   i n s e r t�� 
�� 	 	 	 	�� 
�� 	 	 	 	 v a r   c o d e N a m e   =   " c o d e " + i ;�� 
�� 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( c o d e N a m e ) [ 0 ] . v a l u e   =   c o d e ;   / /  ����  �T��   i n s e r t�� 
�� 	 	 	 	�� 
�� 	 	 	 	 v a r   t a b l e N a m e   =   " t a b l e " + i ;�� 
�� 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( t a b l e N a m e ) [ 0 ] . v a l u e   =   t a b l e ;   / /  ����  �T��   i n s e r t�� 
�� 	 	 	 	�� 
�� 	 	 	 	 v a r   c h e c k   =   d o c u m e n t . g e t E l e m e n t B y I d ( n u m ) ;�� 
�� 	 	 	 	 c h e c k . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 	 	 	�� 
�� 	 	 	 	�� 
�� 	 	 	 	 v a r   s u b j e c t _ s u m   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e ;   / /  �����    �g�H�� 
�� 	 	 	 	 i f ( s u b j e c t _ s u m   = =   " " ) {�� 
�� 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e   =   1 ;�� 
�� 	 	 	 	 } e l s e {�� 
�� 	 	 	 	 	 v a r   s u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e ) ;�� 
�� 	 	 	 	 	 s u m   =   s u m + 1 ;�� 
�� 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e   =   s u m ; 	�� 
�� 	 	 	 	 }�� 
�� 	 	 	 	 h a k j u m _ c h e c k ( i ,   n u m ) ;     	 / /  �Y�  �����  ǅ�%�  ��¤Ҹ�X  ǐ���   n u m  �|  ����  ����  ��Ш���� 
�� 	 	 	 	 v a r   k   =   N u m b e r ( i ) + 1 ;�� 
�� 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s e t _ s c h " + k ) . v a l u e   =   n u m ;�� 
�� 	 	 	 	 b r e a k ;�� 
�� 	 	 	 }�� 
�� 	 	 }�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   n o ( n a m e ,   s c h ) {�� 
�� 	 	 v a r   t e x t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) [ 0 ] . v a l u e ;�� 
�� 	 	 v a r   s u g a n g l i s t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g l i s t " ) ;   / /    �0���\  ���D   . l e n g t h   1���0  ��Ǒ�X�0�L�4��   - 1�� 
�� 	 	 v a r   s i z e   =   s u g a n g l i s t . l e n g t h   - 1 ;�� 
�� 
�� 	 	 f o r ( v a r   i = 0 ;   i < = s i z e ;   i + + ) {�� 
�� 	 	 	 v a r   c h e c k   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g l i s t " ) [ i ] . v a l u e ;�� 
�� 
�� 	 	 	 i f ( c h e c k   = =   t e x t ) {�� 
�� 	 	 	 	 v a r   f   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " c h e c k l i s t " ) [ i ] . v a l u e ;�� 
�� 	 	 	 	�� 
�� 	 	 	 	 v a r   s h o w   =   d o c u m e n t . g e t E l e m e n t B y I d ( f ) ;�� 
�� 	 	 	 	 s h o w . s t y l e . d i s p l a y   =   ' b l o c k ' ;�� 
�� 	 	 	 	 	 	�� 
�� 	 	 	 	 v a r   s u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e ) ;   / /  �����  ���H�� 
�� 	 	 	 	 s u m   =   s u m - 1 ; 	�� 
�� 	 	 	 	 i f ( s u m   < =   0 ) {�� 
�� 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e   =   " " ;�� 
�� 	 	 	 	 } e l s e {�� 
�� 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e   =   s u m ;�� 
�� 	 	 	 	 }�� 
�� 	 	 	 }�� 
�� 	 	 }�� 
�� 	�� 
�� 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) [ 0 ] . v a l u e   =   " " ; 	 / /  ����  ��0�T�� 
�� 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t " + n a m e ) [ 0 ] . v a l u e   =   " " ; 	 / /  �l��  ��0�T�� 
�� 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " p r o f e s s o r " + n a m e ) [ 0 ] . v a l u e   =   " " ;   / /  �����P�  ��0�T�� 
�� 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m " + n a m e ) [ 0 ] . v a l u e   =   " " ;   / /  �Y�  ��0�T�� 
�� 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " c o d e " + n a m e ) [ 0 ] . v a l u e   =   " " ;   / /����  �T��  ��0�T�� 
�� 	 	�� 
�� 	 	 h a k j u m _ c h e c k ( n a m e ) ;�� 
�� 	 	 v a r   k   =   N u m b e r ( n a m e ) + 1 ;�� 
�� 	 	 v a r   s c h   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s e t _ s c h " + k ) . v a l u e ;�� 
�� 	 	 s c h e d u l e _ d e f a u l t ( s c h ) ;�� 
�� 	�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   s c h e d u l e ( n u m ) {�� 
�� 	 	 v a r   n a m e   =   " s c h _ t i m e " + n u m ;�� 
�� 	 	 v a r   s u b j e c t   =   " s u g a n g s u b j e c t " + n u m ;�� 
�� 	 	 v a r   v a l u e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) ;�� 
�� 	 	 v a r   j   =   ( M a t h . r o u n d ( M a t h . r a n d o m ( ) * 6 ) ) ;�� 
�� 	 	�� 
�� 	 	 f o r ( v a r   i = 0 ;   i < v a l u e . l e n g t h ;   i + + ) {       	 	 	 / /  �ܬ�\��  ��  �\���� 
�� 	 	 	 v a r   s c h   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) [ i ] . v a l u e ;�� 
�� 	 	 	 v a r   c   =   d o c u m e n t . g e t E l e m e n t B y I d ( s c h ) ;�� 
�� 	 	 	 v a r   c o l o r   =   [ " # F F 5 E 0 0 " , " F F B B 0 0 " , " F F E 4 0 0 " , " # A B F 2 0 0 " , " # 1 D D B 1 6 " , " # 0 0 5 4 F F " , " # 0 1 0 0 F F " ] ;�� 
�� 	 	 	 c . s t y l e . b a c k g r o u n d C o l o r = c o l o r [ j ] ;  �� 
�� 	 	 	�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s c h _ " + s c h ) [ 0 ] . v a l u e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( s u b j e c t ) [ 0 ] . v a l u e ;�� 
�� 	 	 }�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   s c h e d u l e _ d e f a u l t ( n u m ) { 	�� 
�� 	 	 v a r   n a m e   =   " s c h _ t i m e " + n u m ;�� 
�� 	 	 v a r   v a l u e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) ;�� 
�� 	 	�� 
�� 	 	 f o r ( v a r   i = 0 ;   i < v a l u e . l e n g t h ;   i + + ) {       	 	 	 / /�ܬ�\��  ��    ��0�T�� 
�� 	 	 	 v a r   s c h   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) [ i ] . v a l u e ;�� 
�� 	 	 	 v a r   c   =   d o c u m e n t . g e t E l e m e n t B y I d ( s c h ) ;  �� 
�� 	 	 	 c . s t y l e . b a c k g r o u n d C o l o r = " w h i t e " ;  �� 
�� 	 	 	�� 
�� 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s c h _ " + s c h ) [ 0 ] . v a l u e   =   " " ;�� 
�� 	 	 }�� 
�� 	 }�� 
�� 
�� 	 f u n c t i o n   t h i s A ( ) {�� 
�� 	 	 v a r   A   =   d o c u m e n t . g e t E l e m e n t B y I d ( " t y p e A " ) ;�� 
�� 	 	 v a r   B   =   d o c u m e n t . g e t E l e m e n t B y I d ( " t y p e B " ) ;�� 
�� 	 	�� 
�� 	 	 A . s t y l e . d i s p l a y   =   ' b l o c k ' ;�� 
�� 	 	 B . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   t h i s B ( ) {�� 
�� 	 	 v a r   A   =   d o c u m e n t . g e t E l e m e n t B y I d ( " t y p e A " ) ;�� 
�� 	 	 v a r   B   =   d o c u m e n t . g e t E l e m e n t B y I d ( " t y p e B " ) ;�� 
�� 	 	�� 
�� 	 	 B . s t y l e . d i s p l a y   =   ' b l o c k ' ;�� 
�� 	 	 A . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 }�� 
�� 	�� 
�� 	 s e t I n t e r v a l ( " h i d e S u b j e c t ( ) " ,   5 0 0 ) ;   / /  �  �Ȳ�  ǐ��  ��Չ�� 
�� 	 s e t I n t e r v a l ( " h i d e B u t t o n ( ) " ,   5 0 0 ) ;   / /  �  �Ȳ�  ǐ��  ��Չ�� 
�� 	�� 
�� 	 f u n c t i o n   s e l e c t R a d i o ( s e l e c t ,   m _ c o d e ,   y _ g r a d e ,   s t u _ n u m ,   s t u _ g r a d e )   {�� 
�� 	 	�� 
�� 	 	�� 
�� 	 	 v a r   p a r a m   =   " m _ c o d e = " + m _ c o d e + " & y _ g r a d e = " + y _ g r a d e + " & s t u _ n u m = " + s t u _ n u m + " & s t u _ g r a d e = " + s t u _ g r a d e ;�� 
�� 	 	�� 
�� 	 	 v a r   x m l h t t p ;�� 
�� 	 	�� 
�� 	 	 i f   ( w i n d o w . X M L H t t p R e q u e s t )   {    �� 
�� 	 	 	 x m l h t t p   =   n e w   X M L H t t p R e q u e s t ( ) ;   / /     I E 7 + ,   F i r e f o x ,   C h r o m e ,   O p e r a ,   S a f a r i�� 
�� 	 	 }   e l s e   {        �� 
�� 	 	 	 x m l h t t p   =   n e w   A c t i v e X O b j e c t ( " M i c r o s o f t . X M L H T T P " ) ;     / /   I E 6 ,   I E 5  �� 
�� 	 	 }�� 
�� 	 	�� 
�� 	 	 x m l h t t p . o n r e a d y s t a t e c h a n g e   =   f u n c t i o n ( )   {�� 
�� 	 	 	 i f   ( x m l h t t p . r e a d y S t a t e   = =   4   & &   x m l h t t p . s t a t u s   = =   2 0 0 )   {�� 
�� 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " s e l e c t e d " ) . i n n e r H T M L   =   x m l h t t p . r e s p o n s e T e x t ; 	�� 
�� 	 	 	 }�� 
�� 	 	 } ;�� 
�� 	 	�� 
�� 	 	 i f   ( s e l e c t   = =   " m a j o r " )   { 	 	�� 
�� 	 	 	 x m l h t t p . o p e n ( " G E T " ,   " s e l e c t M a j o r . k h ? " + p a r a m ,   t r u e ) ; 	 	 	�� 
�� 	 	 }�� 
�� 	 	 i f   ( s e l e c t   = =   " l i b e r a l " )   {�� 
�� 	 	 	 x m l h t t p . o p e n ( " G E T " ,   " s e l e c t L i b e r a l . k h " ,   t r u e ) ; 	�� 
�� 	 	 }�� 
�� 	 	�� 
�� 	 	 x m l h t t p . s e n d ( ) ;�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   h i d e B u t t o n ( ) {�� 
��   	 	 v a r   l i s t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m l i s t " ) ;�� 
�� 	 	 f o r ( v a r   i = 1 ;   i < = l i s t . l e n g t h ;   i + + ) {�� 
�� 
�� 	 	 	 	 v a r   A n a m e   =   " A b u t t o n " + i ;�� 
�� 	 	 	 	 v a r   B n a m e   =   " B b u t t o n " + i ;�� 
�� 	 	 	�� 
�� 	 	 	 	 v a r   A   =   d o c u m e n t . g e t E l e m e n t B y I d ( A n a m e ) ;�� 
�� 	 	 	 	 v a r   B   =   d o c u m e n t . g e t E l e m e n t B y I d ( B n a m e ) ;�� 
�� 	 	 	 	�� 
�� 	 	 	 	 B . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 	 	 	 A . s t y l e . d i s p l a y   =   ' b l o c k ' ;  �� 
�� 	 	 	 	�� 
�� 	 	 	 	 v a r   s u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m _ s u m " ) [ 0 ] . v a l u e )   +   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m l i s t " ) [ i - 1 ] . v a l u e ) ;�� 
�� 	 	 	 	 	 	 	�� 
�� 	 	 	 	 i f ( s u m   >   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h i g h l i m i t _ h a k j u m " ) [ 0 ] . v a l u e   ) {    �� 
�� 	 	 	 	 	�� 
�� 	 	 	 	 	 v a r   A n a m e   =   " A b u t t o n " + i ;�� 
�� 	 	 	 	 	 v a r   B n a m e   =   " B b u t t o n " + i ;�� 
�� 	 	 	 	�� 
�� 	 	 	 	 	 v a r   A   =   d o c u m e n t . g e t E l e m e n t B y I d ( A n a m e ) ;�� 
�� 	 	 	 	 	 v a r   B   =   d o c u m e n t . g e t E l e m e n t B y I d ( B n a m e ) ;�� 
�� 	 	 	 	 	�� 
�� 	 	 	 	 	 B . s t y l e . d i s p l a y   =   ' b l o c k ' ;�� 
�� 	 	 	 	 	 A . s t y l e . d i s p l a y   =   ' n o n e ' ;  �� 
�� 	 	 	 	�� 
�� 	 	 	 }  �� 
�� 	�� 
�� 	 	 }  �� 
�� 	 }�� 
�� 
�� 	 f u n c t i o n   h i d e S u b j e c t ( ) {�� 
�� 	�� 
�� 	 	 f o r ( v a r   i = 0 ;   i < = 9 ;   i + + ) {�� 
�� 	 	 	 v a r   k   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " c o d e " + i ) [ 0 ] . v a l u e ;�� 
�� 	 	 	 v a r   s u g a n g l i s t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g l i s t " ) ;�� 
�� 	 	 	�� 
�� 	 	 	 i f ( k   ! =   " " ) {�� 
�� 	 	 	 	 v a r   c h k _ s u b j e c t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " c o d e " + i ) [ 0 ] . v a l u e ;�� 
�� 	 	 	�� 
�� 	 	 	 	 f o r ( v a r   k = 1 ;   k < = s u g a n g l i s t . l e n g t h ;   k + + ) {�� 
�� 	 	 	 	 v a r   n u m   =   N u m b e r ( k - 1 ) ;  �� 
�� 	 	 	 	 v a r   s u b j e c t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " l _ c o d e " ) [ n u m ] . v a l u e ;�� 
�� 	 	 	 	 	 i f ( c h k _ s u b j e c t   = =   s u b j e c t ) {�� 
�� 	 	 	 	 	 	 v a r   h i d d e n N u m   =   N u m b e r ( n u m + 1 ) ;�� 
�� 	 	 	 	 	 	 v a r   c h e c k   =   d o c u m e n t . g e t E l e m e n t B y I d ( h i d d e n N u m ) ;�� 
�� 	 	 	 	 	 	 c h e c k . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 	 	 	 	 }     	 	 	 	�� 
�� 	 	 	 	   }  �� 
�� 	 	 	 } 	�� 
�� 	 	 }    �� 
�� 	 }  �� 
�� 	�� 
�� 	 f u n c t i o n   c h k _ i t ( ) {�� 
�� 	 	 v a r   l o w l i m i t _ h a k j u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " l o w l i m i t _ h a k j u m " ) [ 0 ] . v a l u e ) ;   / /  �\�   Ɣ�l  �Y��� 
�� 	 	 v a r   h a k j u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m _ s u m " ) [ 0 ] . v a l u e ) ;   / /��̭�\  �Y��� 
�� 	 	�� 
�� 	 	 i f ( h a k j u m   <   l o w l i m i t _ h a k j u m ) {�� 
�� 	 	 	 a l e r t ( "��̭  �Y��t  ��ǐ���Ȳ� . " ) ;�� 
�� 	 	 	 r e t u r n   f a l s e ;�� 
�� 	 	 } e l s e {�� 
�� 	 	 	 r e t u r n   t r u e ;�� 
�� 	 	 }�� 
�� 	 }�� 
�� 
�� 	 w i n d o w . h i s t o r y . f o r w a r d ( ) ;   / /  ���\� �0  �)��
=======
��  
  
 	 f u n c t i o n   b o d y ( ) {  
 	 	 a l e r t ( " b o d y " ) ;  
 	 	  
 	 	 v a r   h i d e   =   d o c u m e n t . g e t E l e m e n t B y I d ( " t y p e B " ) ;   / /  �Pő  ��  �(�@ ( d e f a u l t )  
 	 	 h i d e . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 	  
 	 / *   	 v a r   c   =   d o c u m e n t . g e t E l e m e n t B y I d ( " 1 0 1 " ) ;  
 	 	 c . s t y l e . b a c k g r o u n d C o l o r = " b l u e " ;   * /  
 	  
 	 	 f o r ( v a r   i = 0 ;   i < = 9 ;   i + + ) {  
 	 	 	 v a r   t y p e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ t y p e " ) [ i ] . v a l u e ;  
 	 	 	 v a r   c o d e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ c o d e " ) [ i ] . v a l u e ;  
 	 	 	 v a r   t a b l e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ t a b l e " ) [ i ] . v a l u e ;  
 	 	 	 v a r   n a m e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ n a m e " ) [ i ] . v a l u e ;  
 	 	 	 v a r   h a k j u m   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ h a k j u m " ) [ i ] . v a l u e ;  
 	 	 	 v a r   p r o f e s s o r   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " q _ p r o f e s s o r " ) [ i ] . v a l u e ;  
 	 	 	  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s e t _ s c h " + i ) [ 0 ] . v a l u e   =   t y p e ;  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( i ) [ 0 ] . v a l u e   =   n a m e ;   / *����  �t�� * /  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " c o d e " + i ) [ 0 ] . v a l u e   =   c o d e ;  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " t a b l e " + i ) [ 0 ] . v a l u e   =   t a b l e ;  
 	 	 	  
 	 	 	 i f ( t y p e   = =   " e " ) {  
 	 	 	 	 t y p e = "�  �D " ;  
 	 	 	 } e l s e {  
 	 	 	 	 t y p e = "�  �  " ;  
 	 	 	 }  
 	 	 	  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t " + i ) [ 0 ] . v a l u e   =   t y p e ;   / *��  ,  ��D * /  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m " + i ) [ 0 ] . v a l u e   =   h a k j u m ;  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " p r o f e s s o r " + i ) [ 0 ] . v a l u e   =   p r o f e s s o r ;  
 	 	  
 	 	 }  
 	 }  
 	  
 	 f u n c t i o n   h a k j u m _ c h e c k ( n u m ,   s c h ) {  
 	 	  
 	 	 v a r   s u g a n g   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g " ) ;   / /    �0���\  ���D   . l e n g t h   1���0  ��Ǒ�X�0�L�4��   - 1  
 	 	 v a r   s i z e   =   s u g a n g . l e n g t h   - 1 ;  
  
 	 	 v a r   h a k j u m _ s u m   =   0 ;       	 	 	 	 / /  �Y�  �g�H  
 	 	 f o r ( v a r   i = 0 ;   i < = s i z e ;   i + + ) {  
 	 	 	 v a r   h a k j u m N a m e   =   " h a k j u m " + i ;  
 	 	 	 v a r   h a k j u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( h a k j u m N a m e ) [ 0 ] . v a l u e ) ;  
 	 	 	   h a k j u m _ s u m   + =   h a k j u m ; 	  
 	 	 }  
 	  
 	 	 i f ( h a k j u m _ s u m   = =   0 ) {  
 	 	 	   h a k j u m _ s u m   =   " " ;  
 	 	 }  
 	  
 	 	 l o w l i m i t _ h a k j u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " l o w l i m i t _ h a k j u m " ) [ 0 ] . v a l u e ) ;   / /  �\�   Ɣ�l  �Y�  
 	 	 h i g h l i m i t _ h a k j u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h i g h l i m i t _ h a k j u m " ) [ 0 ] . v a l u e ) ;   / /  �\��  Ɣ�l  �Y�  
 	 	 i f ( h a k j u m _ s u m   >   h i g h l i m i t _ h a k j u m ) {   / /  Ɣ�l  �Y�  �U�x  �  �g�H  
 	 	 	 a l e r t ( "�\�   �DƔ  �Y��t  ���Ոµ�Ȳ� . " ) ;  
 	 	 	 n o ( n u m ) ; 	   	 	 	 / /  �Y��t  ���  Ո�D�L  ��̭  ���]���  ǐ��  ��� 	  
 	 	 } e l s e   i f ( h a k j u m _ s u m   <   l o w l i m i t _ h a k j u m ) {  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m _ s u m " ) [ 0 ] . v a l u e   =   h a k j u m _ s u m ;  
 	 	 	  
 	 	 	 i f (   s c h   ! =   n u l l ) {  
 	 	 	 	 s c h e d u l e ( s c h ) ;  
 	 	 	 }  
 	 	 	  
 	 	 } e l s e {  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m _ s u m " ) [ 0 ] . v a l u e   =   h a k j u m _ s u m ;  
 	 	 	  
 	 	 	 i f (   s c h   ! =   n u l l ) {  
 	 	 	 	 s c h e d u l e ( s c h ) ;  
 	 	 	 }  
 	 	 }  
 	 	 r e t u r n ;  
 	 }  
 	  
 	 f u n c t i o n   o k ( n u m ) {           / /  ��@  �ܬ� ��  ����̭�t  �Ŵǈ����  �U�x  
 	 	 v a r   n a m e   =   " s c h _ t i m e " + n u m ;  
 	 	 v a r   s u b j e c t   =   " s u g a n g s u b j e c t " + n u m ;  
 	 	 v a r   v a l u e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) ;  
 	 	 v a r   c h e c k   =   0 ;  
 	 	  
 	 	 f o r ( v a r   i = 0 ;   i < v a l u e . l e n g t h ;   i + + ) {       	 	 	  
 	 	 	 v a r   s c h   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) [ i ] . v a l u e ;  
 	 	 	 v a r   c   =   d o c u m e n t . g e t E l e m e n t B y I d ( s c h ) ;  
 	 	 	 v a r   c h k   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s c h _ " + s c h ) [ 0 ] . v a l u e ;  
 	 	 	 i f ( c h k   ! =   " " ) {  
 	 	 	 	 c h e c k   =   c h e c k + 1 ;  
 	 	 	 } 	  
 	 	 }  
 	 	 i f ( c h e c k   = =   0 ) {  
 	 	 	 a d d ( n u m ) ;  
 	 	 } e l s e {  
 	 	 	 a l e r t ( "��  �ܬ�\�|  �U�x�X�8Ɣ   ! ! " ) ;  
 	 	 }  
 	 }  
 	  
 	 f u n c t i o n   a d d ( n u m ) {  
 	 	 v a r   t e x t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g l i s t " ) [ n u m - 1 ] . v a l u e ;   / /  ����  
 	 	 v a r   s u b j e c t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t l i s t " ) [ n u m - 1 ] . v a l u e ;   / /  �l��  
 	 	 v a r   p r o f e s s o r   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " p r o f e s s o r l i s t " ) [ n u m - 1 ] . v a l u e ;   / /  ����  �P�  
 	 	 v a r   h a k j u m   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m l i s t " ) [ n u m - 1 ] . v a l u e ;   / /  �Y�  
 	 	 v a r   c o d e   =     d o c u m e n t . g e t E l e m e n t s B y N a m e ( " l _ c o d e " ) [ n u m - 1 ] . v a l u e ;   / /�����T��  
 	 	 v a r   t a b l e   =     d o c u m e n t . g e t E l e m e n t s B y N a m e ( " t a b l e n a m e " ) [ n u m - 1 ] . v a l u e ;   / /�L�t�  �t��  
 	 	  
 	 	 v a r   s u g a n g   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g " ) ;   / /    �0���\  ���D   . l e n g t h   1���0  ��Ǒ�X�0�L�4��   - 1  
 	 	  
 	 	 f o r ( v a r   i = 0 ;   i < = s u g a n g . l e n g t h ;   i + + ) { 	  
 	 	 	 v a r   v a l u e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( i ) [ 0 ] . v a l u e ;  
 	 	 	  
 	 	 	 i f ( v a l u e   = =   " " ) {  
 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( i ) [ 0 ] . v a l u e   =   t e x t ;   / /  ����   i n s e r t  
 	 	 	 	  
 	 	 	 	 v a r   s u b j e c t N a m e   =   " s u b j e c t " + i ;  
 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( s u b j e c t N a m e ) [ 0 ] . v a l u e   =   s u b j e c t ;   / /  �l��   i n s e r t  
 	 	 	 	  
 	 	 	 	 v a r   p r o f e s s o r N a m e   =   " p r o f e s s o r " + i ;  
 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( p r o f e s s o r N a m e ) [ 0 ] . v a l u e   =   p r o f e s s o r ;   / /  ����  �P�     i n s e r t  
 	 	 	 	  
 	 	 	 	 v a r   h a k j u m N a m e   =   " h a k j u m " + i ;  
 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( h a k j u m N a m e ) [ 0 ] . v a l u e   =   h a k j u m ;   / /  �Y�   i n s e r t  
 	 	 	 	  
 	 	 	 	 v a r   c o d e N a m e   =   " c o d e " + i ;  
 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( c o d e N a m e ) [ 0 ] . v a l u e   =   c o d e ;   / /  ����  �T��   i n s e r t  
 	 	 	 	  
 	 	 	 	 v a r   t a b l e N a m e   =   " t a b l e " + i ;  
 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( t a b l e N a m e ) [ 0 ] . v a l u e   =   t a b l e ;   / /  ����  �T��   i n s e r t  
 	 	 	 	  
 	 	 	 	 v a r   c h e c k   =   d o c u m e n t . g e t E l e m e n t B y I d ( n u m ) ;  
 	 	 	 	 c h e c k . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 	 	 	  
 	 	 	 	  
 	 	 	 	 v a r   s u b j e c t _ s u m   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e ;   / /  �����    �g�H  
 	 	 	 	 i f ( s u b j e c t _ s u m   = =   " " ) {  
 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e   =   1 ;  
 	 	 	 	 } e l s e {  
 	 	 	 	 	 v a r   s u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e ) ;  
 	 	 	 	 	 s u m   =   s u m + 1 ;  
 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e   =   s u m ; 	  
 	 	 	 	 }  
 	 	 	 	 h a k j u m _ c h e c k ( i ,   n u m ) ;     	 / /  �Y�  �����  ǅ�%�  ��¤Ҹ�X  ǐ���   n u m  �|  ����  ����  ��Ш��  
 	 	 	 	 v a r   k   =   N u m b e r ( i ) + 1 ;  
 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s e t _ s c h " + k ) . v a l u e   =   n u m ;  
 	 	 	 	 b r e a k ;  
 	 	 	 }  
 	 	 }  
 	 }  
 	  
 	 f u n c t i o n   n o ( n a m e ,   s c h ) {  
 	 	 v a r   t e x t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) [ 0 ] . v a l u e ;  
 	 	 v a r   s u g a n g l i s t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g l i s t " ) ;   / /    �0���\  ���D   . l e n g t h   1���0  ��Ǒ�X�0�L�4��   - 1  
 	 	 v a r   s i z e   =   s u g a n g l i s t . l e n g t h   - 1 ;  
  
 	 	 f o r ( v a r   i = 0 ;   i < = s i z e ;   i + + ) {  
 	 	 	 v a r   c h e c k   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g l i s t " ) [ i ] . v a l u e ;  
  
 	 	 	 i f ( c h e c k   = =   t e x t ) {  
 	 	 	 	 v a r   f   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " c h e c k l i s t " ) [ i ] . v a l u e ;  
 	 	 	 	  
 	 	 	 	 v a r   s h o w   =   d o c u m e n t . g e t E l e m e n t B y I d ( f ) ;  
 	 	 	 	 s h o w . s t y l e . d i s p l a y   =   ' b l o c k ' ;  
 	 	 	 	 	 	  
 	 	 	 	 v a r   s u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e ) ;   / /  �����  ���H  
 	 	 	 	 s u m   =   s u m - 1 ; 	  
 	 	 	 	 i f ( s u m   < =   0 ) {  
 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e   =   " " ;  
 	 	 	 	 } e l s e {  
 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t _ s u m " ) [ 0 ] . v a l u e   =   s u m ;  
 	 	 	 	 }  
 	 	 	 }  
 	 	 }  
 	  
 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) [ 0 ] . v a l u e   =   " " ; 	 / /  ����  ��0�T  
 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u b j e c t " + n a m e ) [ 0 ] . v a l u e   =   " " ; 	 / /  �l��  ��0�T  
 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " p r o f e s s o r " + n a m e ) [ 0 ] . v a l u e   =   " " ;   / /  �����P�  ��0�T  
 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m " + n a m e ) [ 0 ] . v a l u e   =   " " ;   / /  �Y�  ��0�T  
 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " c o d e " + n a m e ) [ 0 ] . v a l u e   =   " " ;   / /����  �T��  ��0�T  
 	 	  
 	 	 h a k j u m _ c h e c k ( n a m e ) ;  
 	 	 v a r   k   =   N u m b e r ( n a m e ) + 1 ;  
 	 	 v a r   s c h   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s e t _ s c h " + k ) . v a l u e ;  
 	 	 s c h e d u l e _ d e f a u l t ( s c h ) ;  
 	  
 	 }  
 	  
 	 f u n c t i o n   s c h e d u l e ( n u m ) {  
 	 	 v a r   n a m e   =   " s c h _ t i m e " + n u m ;  
 	 	 v a r   s u b j e c t   =   " s u g a n g s u b j e c t " + n u m ;  
 	 	 v a r   v a l u e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) ;  
 	 	 v a r   j   =   ( M a t h . r o u n d ( M a t h . r a n d o m ( ) * 6 ) ) ;  
 	 	  
 	 	 f o r ( v a r   i = 0 ;   i < v a l u e . l e n g t h ;   i + + ) {       	 	 	 / /  �ܬ�\��  ��  �\��  
 	 	 	 v a r   s c h   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) [ i ] . v a l u e ;  
 	 	 	 v a r   c   =   d o c u m e n t . g e t E l e m e n t B y I d ( s c h ) ;  
 	 	 	 v a r   c o l o r   =   [ " # F F 5 E 0 0 " , " F F B B 0 0 " , " F F E 4 0 0 " , " # A B F 2 0 0 " , " # 1 D D B 1 6 " , " # 0 0 5 4 F F " , " # 0 1 0 0 F F " ] ;  
 	 	 	 c . s t y l e . b a c k g r o u n d C o l o r = c o l o r [ j ] ;    
 	 	 	  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s c h _ " + s c h ) [ 0 ] . v a l u e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( s u b j e c t ) [ 0 ] . v a l u e ;  
 	 	 }  
 	 }  
 	  
 	 f u n c t i o n   s c h e d u l e _ d e f a u l t ( n u m ) { 	  
 	 	 v a r   n a m e   =   " s c h _ t i m e " + n u m ;  
 	 	 v a r   v a l u e   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) ;  
 	 	  
 	 	 f o r ( v a r   i = 0 ;   i < v a l u e . l e n g t h ;   i + + ) {       	 	 	 / /�ܬ�\��  ��    ��0�T  
 	 	 	 v a r   s c h   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( n a m e ) [ i ] . v a l u e ;  
 	 	 	 v a r   c   =   d o c u m e n t . g e t E l e m e n t B y I d ( s c h ) ;    
 	 	 	 c . s t y l e . b a c k g r o u n d C o l o r = " w h i t e " ;    
 	 	 	  
 	 	 	 d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s c h _ " + s c h ) [ 0 ] . v a l u e   =   " " ;  
 	 	 }  
 	 }  
  
 	 f u n c t i o n   t h i s A ( ) {  
 	 	 v a r   A   =   d o c u m e n t . g e t E l e m e n t B y I d ( " t y p e A " ) ;  
 	 	 v a r   B   =   d o c u m e n t . g e t E l e m e n t B y I d ( " t y p e B " ) ;  
 	 	  
 	 	 A . s t y l e . d i s p l a y   =   ' b l o c k ' ;  
 	 	 B . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 }  
 	  
 	 f u n c t i o n   t h i s B ( ) {  
 	 	 v a r   A   =   d o c u m e n t . g e t E l e m e n t B y I d ( " t y p e A " ) ;  
 	 	 v a r   B   =   d o c u m e n t . g e t E l e m e n t B y I d ( " t y p e B " ) ;  
 	 	  
 	 	 B . s t y l e . d i s p l a y   =   ' b l o c k ' ;  
 	 	 A . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 }  
 	  
 	 s e t I n t e r v a l ( " h i d e S u b j e c t ( ) " ,   5 0 0 ) ;   / /  �  �Ȳ�  ǐ��  ��Չ  
 	 s e t I n t e r v a l ( " h i d e B u t t o n ( ) " ,   5 0 0 ) ;   / /  �  �Ȳ�  ǐ��  ��Չ  
 	  
 	 f u n c t i o n   s e l e c t R a d i o ( s e l e c t ,   m _ c o d e ,   y _ g r a d e ,   s t u _ n u m ,   s t u _ g r a d e )   {  
 	 	  
 	 	  
 	 	 v a r   p a r a m   =   " m _ c o d e = " + m _ c o d e + " & y _ g r a d e = " + y _ g r a d e + " & s t u _ n u m = " + s t u _ n u m + " & s t u _ g r a d e = " + s t u _ g r a d e ;  
 	 	  
 	 	 v a r   x m l h t t p ;  
 	 	  
 	 	 i f   ( w i n d o w . X M L H t t p R e q u e s t )   {      
 	 	 	 x m l h t t p   =   n e w   X M L H t t p R e q u e s t ( ) ;   / /     I E 7 + ,   F i r e f o x ,   C h r o m e ,   O p e r a ,   S a f a r i  
 	 	 }   e l s e   {          
 	 	 	 x m l h t t p   =   n e w   A c t i v e X O b j e c t ( " M i c r o s o f t . X M L H T T P " ) ;     / /   I E 6 ,   I E 5    
 	 	 }  
 	 	  
 	 	 x m l h t t p . o n r e a d y s t a t e c h a n g e   =   f u n c t i o n ( )   {  
 	 	 	 i f   ( x m l h t t p . r e a d y S t a t e   = =   4   & &   x m l h t t p . s t a t u s   = =   2 0 0 )   {  
 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " s e l e c t e d " ) . i n n e r H T M L   =   x m l h t t p . r e s p o n s e T e x t ; 	  
 	 	 	 }  
 	 	 } ;  
 	 	  
 	 	 i f   ( s e l e c t   = =   " m a j o r " )   { 	 	  
 	 	 	 x m l h t t p . o p e n ( " G E T " ,   " s e l e c t M a j o r . k h ? " + p a r a m ,   t r u e ) ; 	 	 	  
 	 	 }  
 	 	 i f   ( s e l e c t   = =   " l i b e r a l " )   {  
 	 	 	 x m l h t t p . o p e n ( " G E T " ,   " s e l e c t L i b e r a l . k h " ,   t r u e ) ; 	  
 	 	 }  
 	 	  
 	 	 x m l h t t p . s e n d ( ) ;  
 	 }  
 	  
 	 f u n c t i o n   h i d e B u t t o n ( ) {  
   	 	 v a r   l i s t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m l i s t " ) ;  
 	 	 f o r ( v a r   i = 1 ;   i < = l i s t . l e n g t h ;   i + + ) {  
  
 	 	 	 	 v a r   A n a m e   =   " A b u t t o n " + i ;  
 	 	 	 	 v a r   B n a m e   =   " B b u t t o n " + i ;  
 	 	 	  
 	 	 	 	 v a r   A   =   d o c u m e n t . g e t E l e m e n t B y I d ( A n a m e ) ;  
 	 	 	 	 v a r   B   =   d o c u m e n t . g e t E l e m e n t B y I d ( B n a m e ) ;  
 	 	 	 	  
 	 	 	 	 B . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 	 	 	 A . s t y l e . d i s p l a y   =   ' b l o c k ' ;    
 	 	 	 	  
 	 	 	 	 v a r   s u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m _ s u m " ) [ 0 ] . v a l u e )   +   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m l i s t " ) [ i - 1 ] . v a l u e ) ;  
 	 	 	 	 	 	 	  
 	 	 	 	 i f ( s u m   >   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h i g h l i m i t _ h a k j u m " ) [ 0 ] . v a l u e   ) {      
 	 	 	 	 	  
 	 	 	 	 	 v a r   A n a m e   =   " A b u t t o n " + i ;  
 	 	 	 	 	 v a r   B n a m e   =   " B b u t t o n " + i ;  
 	 	 	 	  
 	 	 	 	 	 v a r   A   =   d o c u m e n t . g e t E l e m e n t B y I d ( A n a m e ) ;  
 	 	 	 	 	 v a r   B   =   d o c u m e n t . g e t E l e m e n t B y I d ( B n a m e ) ;  
 	 	 	 	 	  
 	 	 	 	 	 B . s t y l e . d i s p l a y   =   ' b l o c k ' ;  
 	 	 	 	 	 A . s t y l e . d i s p l a y   =   ' n o n e ' ;    
 	 	 	 	  
 	 	 	 }    
 	  
 	 	 }    
 	 }  
  
 	 f u n c t i o n   h i d e S u b j e c t ( ) {  
 	  
 	 	 f o r ( v a r   i = 0 ;   i < = 9 ;   i + + ) {  
 	 	 	 v a r   k   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " c o d e " + i ) [ 0 ] . v a l u e ;  
 	 	 	 v a r   s u g a n g l i s t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " s u g a n g l i s t " ) ;  
 	 	 	  
 	 	 	 i f ( k   ! =   " " ) {  
 	 	 	 	 v a r   c h k _ s u b j e c t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " c o d e " + i ) [ 0 ] . v a l u e ;  
 	 	 	  
 	 	 	 	 f o r ( v a r   k = 1 ;   k < = s u g a n g l i s t . l e n g t h ;   k + + ) {  
 	 	 	 	 v a r   n u m   =   N u m b e r ( k - 1 ) ;    
 	 	 	 	 v a r   s u b j e c t   =   d o c u m e n t . g e t E l e m e n t s B y N a m e ( " l _ c o d e " ) [ n u m ] . v a l u e ;  
 	 	 	 	 	 i f ( c h k _ s u b j e c t   = =   s u b j e c t ) {  
 	 	 	 	 	 	 v a r   h i d d e n N u m   =   N u m b e r ( n u m + 1 ) ;  
 	 	 	 	 	 	 v a r   c h e c k   =   d o c u m e n t . g e t E l e m e n t B y I d ( h i d d e n N u m ) ;  
 	 	 	 	 	 	 c h e c k . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 	 	 	 	 }     	 	 	 	  
 	 	 	 	   }    
 	 	 	 } 	  
 	 	 }      
 	 }    
 	  
 	 f u n c t i o n   c h k _ i t ( ) {  
 	 	 v a r   l o w l i m i t _ h a k j u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " l o w l i m i t _ h a k j u m " ) [ 0 ] . v a l u e ) ;   / /  �\�   Ɣ�l  �Y�  
 	 	 v a r   h a k j u m   =   N u m b e r ( d o c u m e n t . g e t E l e m e n t s B y N a m e ( " h a k j u m _ s u m " ) [ 0 ] . v a l u e ) ;   / /��̭�\  �Y�  
 	 	  
 	 	 i f ( h a k j u m   <   l o w l i m i t _ h a k j u m ) {  
 	 	 	 a l e r t ( "��̭  �Y��t  ��ǐ���Ȳ� . " ) ;  
 	 	 	 r e t u r n   f a l s e ;  
 	 	 } e l s e {  
 	 	 	 r e t u r n   t r u e ;  
 	 	 }  
 	 }  
  
 	 w i n d o w . h i s t o r y . f o r w a r d ( ) ;   / /  ���\� �0  �)��
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
