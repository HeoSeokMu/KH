<<<<<<< HEAD
�� v a r   s t a r t   =   n u l l ;�� 
�� 	 v a r   e n d   =   n u l l ;�� 
�� 	�� 
�� 	 f u n c t i o n   a u t o _ d e f a u l t ( t y p e ,   m a j o r ) {�� 
�� 	 	 i f ( t y p e   = =   "�P� " ) {�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . t y p e . v a l u e   =   '�P� ' ;�� 
�� 	 	 } e l s e   i f ( t y p e   = =   "�P���� " ) {�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . t y p e . v a l u e   =   '�P���� ' ;�� 
�� 	 	 }�� 
�� 	 	�� 
�� 	 }�� 
�� 	�� 
�� 	 v a r   s _ y e a r   =   n u l l ;�� 
�� 	 v a r   s _ m o n t h   =   n u l l ;�� 
�� 
�� 	 v a r   e _ y e a r   =   n u l l ;�� 
�� 	 v a r   e _ m o n t h   =   n u l l ;�� 
�� 	�� 
�� 	 f u n c t i o n   c h k _ d d ( y y , m m , d d ,   c h k ,   i ) {�� 
�� 	 	�� 
�� 	 	 i f ( c h k   = =   " s t a r t " ) {�� 
�� 	 	 	 i f ( m m   <   1 0 )   {�� 
�� 	 	 	 	 m m   =   0 + m m ;�� 
�� 	 	 	 }�� 
�� 	 	 	 i f ( d d   <   1 0 )   {�� 
�� 	 	 	 	 d d   =   0 + d d ;�� 
�� 	 	 	 }�� 
�� 	 	 	 s _ y e a r   =   y y ;�� 
�� 	 	 	 s _ m o n t h   =   m m ;�� 
�� 	 	 	 s t a r t   =   N u m b e r ( y y + m m + d d ) ;�� 
�� 	 	 } e l s e {�� 
�� 	 	 	 i f ( m m   <   1 0 )   {�� 
�� 	 	 	 	 m m   =   0 + m m ;�� 
�� 	 	 	 }�� 
�� 	 	 	 i f ( d d   <   1 0 )   {�� 
�� 	 	 	 	 d d   =   0 + d d ;�� 
�� 	 	 	 }�� 
�� 	 	 	 e _ y e a r   =   y y ;�� 
�� 	 	 	 e _ m o n t h   =   m m ;�� 
�� 	 	 	 e n d   =   N u m b e r ( y y + m m + d d ) ;�� 
�� 	 	 }�� 
�� 	 	 	�� 
�� 	 	 i f ( s t a r t   ! =   n u l l   & &   e n d   ! =   n u l l ) { 	�� 
�� 	 	 	 i f ( s t a r t   > =   e n d ) {�� 
�� 	 	 	 	�� 
�� 	 	 	 	 i f ( i   = =   ' y ' ) {�� 
�� 	 	 	 	 	 i f ( N u m b e r ( s _ y e a r )   >   N u m b e r ( e _ y e a r ) ) {�� 
�� 	 	 	 	 	 	 u s e r _ i n p u t . v a c E n d _ y y . v a l u e   =   0 ;�� 
�� 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e E r r o r " ) . s t y l e . d i s p l a y   =   ' ' ;�� 
�� 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e O k " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 	 	 	 	 }�� 
�� 	 	 	 	 } e l s e   i f   (   i   = =   ' m ' ) {�� 
�� 	 	 	 	 	 i f ( N u m b e r ( s _ y e a r + s _ m o n t h )   >   N u m b e r ( e _ y e a r + e _ m o n t h ) ) {�� 
�� 	 	 	 	 	 	 u s e r _ i n p u t . v a c E n d _ m m . v a l u e   =   0 ;�� 
�� 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e E r r o r " ) . s t y l e . d i s p l a y   =   ' ' ;�� 
�� 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e O k " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 	 	 	 	 }�� 
�� 	 	 	 	 } e l s e {�� 
�� 	 	 	 	 	 i f ( s t a r t   >   e n d ) {�� 
�� 	 	 	 	 	 	 u s e r _ i n p u t . v a c E n d _ d d . v a l u e   =   0 ;�� 
�� 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e E r r o r " ) . s t y l e . d i s p l a y   =   ' ' ;�� 
�� 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e O k " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 	 	 	 	 }�� 
�� 	 	 	 	 }�� 
�� 	 	 	 } e l s e   i f ( s t a r t   < =   e n d ) {�� 
�� 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e E r r o r " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e O k " ) . s t y l e . d i s p l a y   =   ' ' ;�� 
�� 	 	 	 }�� 
�� 
�� 	 	 }�� 
�� 	 	 	�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   h u g a G o ( ) {�� 
�� 	 	�� 
�� 	 	 i f ( d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e O k " ) . s t y l e . d i s p l a y   = =   ' n o n e '�� 
�� 	 	 	 	 & &   d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e E r r o r " ) . s t y l e . d i s p l a y   = =   ' ' ) {�� 
�� 	 	 	 a l e r t ( "�l���|ǐ�|  �U�x�t���8Ɣ . " ) ;�� 
�� 	 	 	 r e t u r n   f a l s e ;�� 
�� 	 	 } e l s e {�� 
�� 	 	 	 i f ( c o n f i r m ( "�4� ��̭�D  �X�ܬ�µ�ȮL ? " ) ) {�� 
�� 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n F o r m P r o . k h ' ;�� 
�� 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;�� 
�� 	 	 	 }�� 
�� 	 	 }�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   v i e w S e t ( t y p e ,   r e s u l t ) {�� 
�� 	 	 i f ( t y p e   = =   "�P� " ) {�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . t y p e . v a l u e   =   '�P� ' ;�� 
�� 	 	 } e l s e   i f ( t y p e   = =   "�P���� " ) {�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . t y p e . v a l u e   =   '�P���� ' ;�� 
�� 	 	 }�� 
�� 	 	�� 
�� 	 	 i f ( r e s u l t   = =   "��̘�� " ) {�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . r e s u l t . v a l u e   =   '��̘�� ' ;�� 
�� 	 	 } e l s e   i f ( r e s u l t   = =   "¹�x " ) {�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . r e s u l t . v a l u e   =   '¹�x ' ;�� 
�� 	 	 } e l s e   i f ( r e s u l t   = =   "�p� " ) {�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . r e s u l t . v a l u e   =   '�p� ' ;�� 
�� 	 	 }�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   C h a n g e D a t e ( ) {�� 
�� 	 	�� 
�� 	 	 v a r   o r i g i n a l   =   d o c u m e n t . g e t E l e m e n t B y I d ( " o r i g i n a l " ) ;�� 
�� 	 	 v a r   n e w D a t e   =   d o c u m e n t . g e t E l e m e n t B y I d ( " n e w D a t e " ) ;�� 
�� 	 	�� 
�� 	 	 i f ( d o c u m e n t . g e t E l e m e n t B y I d ( " c h a n g e C h e c k " ) . c h e c k e d   = =   t r u e ) {�� 
�� 	 	 	 n e w D a t e . s t y l e . d i s p l a y   =   ' ' ;�� 
�� 	 	 	 o r i g i n a l . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ y y . d i s a b l e d   =   ' ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ m m . d i s a b l e d   =   ' ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ d d . d i s a b l e d   =   ' ' ;�� 
�� 	 	 	�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ y y . d i s a b l e d   =   ' ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ m m . d i s a b l e d   =   ' ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ d d . d i s a b l e d   =   ' ' ;�� 
�� 	 	 } e l s e {�� 
�� 	 	 	 n e w D a t e . s t y l e . d i s p l a y   =   ' n o n e ' ;�� 
�� 	 	 	 o r i g i n a l . s t y l e . d i s p l a y   =   ' ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ y y . d i s a b l e d   =   ' d i s a b l e d ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ m m . d i s a b l e d   =   ' d i s a b l e d ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ d d . d i s a b l e d   =   ' d i s a b l e d ' ;�� 
�� 	 	 	�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ y y . d i s a b l e d   =   ' d i s a b l e d ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ m m . d i s a b l e d   =   ' d i s a b l e d ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ d d . d i s a b l e d   =   ' d i s a b l e d ' ;�� 
�� 	 	 }�� 
�� 	 	�� 
�� 	 	�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   h u g a M o d i f y ( ) {�� 
�� 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n M o d i f y . k h ' ;�� 
�� 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   g o M o d i f y ( ) {�� 
�� 	 	 i f ( d o c u m e n t . g e t E l e m e n t B y I d ( " c h a n g e C h e c k " ) . c h e c k e d   = =   t r u e ) {�� 
�� 	 	 	 i f ( d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ y y . v a l u e   = =   '��� ' ) {�� 
�� 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;�� 
�� 	 	 	 	 r e t u r n   f a l s e ;�� 
�� 	 	 	 } e l s e   i f ( d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ m m . v a l u e   = =   '�� ' ) {�� 
�� 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;�� 
�� 	 	 	 	 r e t u r n   f a l s e ;�� 
�� 	 	 	 } e l s e   i f ( d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ d d . v a l u e   = =   '�| ' ) {�� 
�� 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;�� 
�� 	 	 	 	 r e t u r n   f a l s e ;�� 
�� 	 	 	 } e l s e   i f ( d o c u m e n t . u s e r _ i n p u t . v a c E n d _ y y . v a l u e   = =   ' 0 ' ) {�� 
�� 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;�� 
�� 	 	 	 	 r e t u r n   f a l s e ;�� 
�� 	 	 	 } e l s e   i f ( d o c u m e n t . u s e r _ i n p u t . v a c E n d _ m m . v a l u e   = =   ' 0 ' ) {�� 
�� 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;�� 
�� 	 	 	 	 r e t u r n   f a l s e ;�� 
�� 	 	 	 } e l s e   i f ( d o c u m e n t . u s e r _ i n p u t . v a c E n d _ d d . v a l u e   = =   ' 0 ' ) {�� 
�� 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;�� 
�� 	 	 	 	 r e t u r n   f a l s e ;�� 
�� 	 	 	 } e l s e {�� 
�� 	 	 	 	 i f ( c o n f i r m ( "�4� ��̭�D  ��  �X�ܬ�µ�ȮL ? " ) ) {�� 
�� 	 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n M o d i f y P r o . k h ' ;�� 
�� 	 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;�� 
�� 	 	 	 	 }�� 
�� 	 	 	 }�� 
�� 	 	 } e l s e {�� 
�� 	 	 	 i f ( c o n f i r m ( "�4� ��̭�D  ��  �X�ܬ�µ�ȮL ? " ) ) {�� 
�� 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n M o d i f y P r o . k h ' ;�� 
�� 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;�� 
�� 	 	 	 }�� 
�� 	 	 }�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   d e l H u g a ( ) {�� 
�� 	 	 i f ( c o n f i r m ( "�4� ��̭�D  ���  �X�ܬ�µ�ȮL ? " ) ) {�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n D e l e t e . k h ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;�� 
�� 	 	 }�� 
�� 	 }�� 
�� 	�� 
�� 	 f u n c t i o n   a c c e p t H u g a ( ) {�� 
�� 	 	 i f ( c o n f i r m ( "�4� ��̭�D  ¹�x  �X�ܬ�µ�ȮL ? " ) ) {�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n A c c e p t . k h ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;�� 
�� 	 	 }�� 
�� 	 }�� 
�� 	 f u n c t i o n   d e n y H u g a ( ) {�� 
�� 	 	 i f ( c o n f i r m ( "�4� ��̭�D  �p�  �X�ܬ�µ�ȮL ? " ) ) {�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n D e n y . k h ' ;�� 
�� 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;�� 
�� 	 	 }�� 
�� 	 }
=======
�� v a r   s t a r t   =   n u l l ;  
 	 v a r   e n d   =   n u l l ;  
 	  
 	 f u n c t i o n   a u t o _ d e f a u l t ( t y p e ,   m a j o r ) {  
 	 	 i f ( t y p e   = =   "�P� " ) {  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . t y p e . v a l u e   =   '�P� ' ;  
 	 	 } e l s e   i f ( t y p e   = =   "�P���� " ) {  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . t y p e . v a l u e   =   '�P���� ' ;  
 	 	 }  
 	 	  
 	 }  
 	  
 	 v a r   s _ y e a r   =   n u l l ;  
 	 v a r   s _ m o n t h   =   n u l l ;  
  
 	 v a r   e _ y e a r   =   n u l l ;  
 	 v a r   e _ m o n t h   =   n u l l ;  
 	  
 	 f u n c t i o n   c h k _ d d ( y y , m m , d d ,   c h k ,   i ) {  
 	 	  
 	 	 i f ( c h k   = =   " s t a r t " ) {  
 	 	 	 i f ( m m   <   1 0 )   {  
 	 	 	 	 m m   =   0 + m m ;  
 	 	 	 }  
 	 	 	 i f ( d d   <   1 0 )   {  
 	 	 	 	 d d   =   0 + d d ;  
 	 	 	 }  
 	 	 	 s _ y e a r   =   y y ;  
 	 	 	 s _ m o n t h   =   m m ;  
 	 	 	 s t a r t   =   N u m b e r ( y y + m m + d d ) ;  
 	 	 } e l s e {  
 	 	 	 i f ( m m   <   1 0 )   {  
 	 	 	 	 m m   =   0 + m m ;  
 	 	 	 }  
 	 	 	 i f ( d d   <   1 0 )   {  
 	 	 	 	 d d   =   0 + d d ;  
 	 	 	 }  
 	 	 	 e _ y e a r   =   y y ;  
 	 	 	 e _ m o n t h   =   m m ;  
 	 	 	 e n d   =   N u m b e r ( y y + m m + d d ) ;  
 	 	 }  
 	 	 	  
 	 	 i f ( s t a r t   ! =   n u l l   & &   e n d   ! =   n u l l ) { 	  
 	 	 	 i f ( s t a r t   > =   e n d ) {  
 	 	 	 	  
 	 	 	 	 i f ( i   = =   ' y ' ) {  
 	 	 	 	 	 i f ( N u m b e r ( s _ y e a r )   >   N u m b e r ( e _ y e a r ) ) {  
 	 	 	 	 	 	 u s e r _ i n p u t . v a c E n d _ y y . v a l u e   =   0 ;  
 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e E r r o r " ) . s t y l e . d i s p l a y   =   ' ' ;  
 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e O k " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 	 	 	 	 }  
 	 	 	 	 } e l s e   i f   (   i   = =   ' m ' ) {  
 	 	 	 	 	 i f ( N u m b e r ( s _ y e a r + s _ m o n t h )   >   N u m b e r ( e _ y e a r + e _ m o n t h ) ) {  
 	 	 	 	 	 	 u s e r _ i n p u t . v a c E n d _ m m . v a l u e   =   0 ;  
 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e E r r o r " ) . s t y l e . d i s p l a y   =   ' ' ;  
 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e O k " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 	 	 	 	 }  
 	 	 	 	 } e l s e {  
 	 	 	 	 	 i f ( s t a r t   >   e n d ) {  
 	 	 	 	 	 	 u s e r _ i n p u t . v a c E n d _ d d . v a l u e   =   0 ;  
 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e E r r o r " ) . s t y l e . d i s p l a y   =   ' ' ;  
 	 	 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e O k " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 	 	 	 	 }  
 	 	 	 	 }  
 	 	 	 } e l s e   i f ( s t a r t   < =   e n d ) {  
 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e E r r o r " ) . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 	 	 	 d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e O k " ) . s t y l e . d i s p l a y   =   ' ' ;  
 	 	 	 }  
  
 	 	 }  
 	 	 	  
 	 }  
 	  
 	 f u n c t i o n   h u g a G o ( ) {  
 	 	  
 	 	 i f ( d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e O k " ) . s t y l e . d i s p l a y   = =   ' n o n e '  
 	 	 	 	 & &   d o c u m e n t . g e t E l e m e n t B y I d ( " d a t e E r r o r " ) . s t y l e . d i s p l a y   = =   ' ' ) {  
 	 	 	 a l e r t ( "�l���|ǐ�|  �U�x�t���8Ɣ . " ) ;  
 	 	 	 r e t u r n   f a l s e ;  
 	 	 } e l s e {  
 	 	 	 i f ( c o n f i r m ( "�4� ��̭�D  �X�ܬ�µ�ȮL ? " ) ) {  
 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n F o r m P r o . k h ' ;  
 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;  
 	 	 	 }  
 	 	 }  
 	 }  
 	  
 	 f u n c t i o n   v i e w S e t ( t y p e ,   r e s u l t ) {  
 	 	 i f ( t y p e   = =   "�P� " ) {  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . t y p e . v a l u e   =   '�P� ' ;  
 	 	 } e l s e   i f ( t y p e   = =   "�P���� " ) {  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . t y p e . v a l u e   =   '�P���� ' ;  
 	 	 }  
 	 	  
 	 	 i f ( r e s u l t   = =   "��̘�� " ) {  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . r e s u l t . v a l u e   =   '��̘�� ' ;  
 	 	 } e l s e   i f ( r e s u l t   = =   "¹�x " ) {  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . r e s u l t . v a l u e   =   '¹�x ' ;  
 	 	 } e l s e   i f ( r e s u l t   = =   "�p� " ) {  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . r e s u l t . v a l u e   =   '�p� ' ;  
 	 	 }  
 	 }  
 	  
 	 f u n c t i o n   C h a n g e D a t e ( ) {  
 	 	  
 	 	 v a r   o r i g i n a l   =   d o c u m e n t . g e t E l e m e n t B y I d ( " o r i g i n a l " ) ;  
 	 	 v a r   n e w D a t e   =   d o c u m e n t . g e t E l e m e n t B y I d ( " n e w D a t e " ) ;  
 	 	  
 	 	 i f ( d o c u m e n t . g e t E l e m e n t B y I d ( " c h a n g e C h e c k " ) . c h e c k e d   = =   t r u e ) {  
 	 	 	 n e w D a t e . s t y l e . d i s p l a y   =   ' ' ;  
 	 	 	 o r i g i n a l . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ y y . d i s a b l e d   =   ' ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ m m . d i s a b l e d   =   ' ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ d d . d i s a b l e d   =   ' ' ;  
 	 	 	  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ y y . d i s a b l e d   =   ' ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ m m . d i s a b l e d   =   ' ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ d d . d i s a b l e d   =   ' ' ;  
 	 	 } e l s e {  
 	 	 	 n e w D a t e . s t y l e . d i s p l a y   =   ' n o n e ' ;  
 	 	 	 o r i g i n a l . s t y l e . d i s p l a y   =   ' ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ y y . d i s a b l e d   =   ' d i s a b l e d ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ m m . d i s a b l e d   =   ' d i s a b l e d ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ d d . d i s a b l e d   =   ' d i s a b l e d ' ;  
 	 	 	  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ y y . d i s a b l e d   =   ' d i s a b l e d ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ m m . d i s a b l e d   =   ' d i s a b l e d ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . v a c E n d _ d d . d i s a b l e d   =   ' d i s a b l e d ' ;  
 	 	 }  
 	 	  
 	 	  
 	 }  
 	  
 	 f u n c t i o n   h u g a M o d i f y ( ) {  
 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n M o d i f y . k h ' ;  
 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;  
 	 }  
 	  
 	 f u n c t i o n   g o M o d i f y ( ) {  
 	 	 i f ( d o c u m e n t . g e t E l e m e n t B y I d ( " c h a n g e C h e c k " ) . c h e c k e d   = =   t r u e ) {  
 	 	 	 i f ( d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ y y . v a l u e   = =   '��� ' ) {  
 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;  
 	 	 	 	 r e t u r n   f a l s e ;  
 	 	 	 } e l s e   i f ( d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ m m . v a l u e   = =   '�� ' ) {  
 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;  
 	 	 	 	 r e t u r n   f a l s e ;  
 	 	 	 } e l s e   i f ( d o c u m e n t . u s e r _ i n p u t . v a c S t a r t _ d d . v a l u e   = =   '�| ' ) {  
 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;  
 	 	 	 	 r e t u r n   f a l s e ;  
 	 	 	 } e l s e   i f ( d o c u m e n t . u s e r _ i n p u t . v a c E n d _ y y . v a l u e   = =   ' 0 ' ) {  
 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;  
 	 	 	 	 r e t u r n   f a l s e ;  
 	 	 	 } e l s e   i f ( d o c u m e n t . u s e r _ i n p u t . v a c E n d _ m m . v a l u e   = =   ' 0 ' ) {  
 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;  
 	 	 	 	 r e t u r n   f a l s e ;  
 	 	 	 } e l s e   i f ( d o c u m e n t . u s e r _ i n p u t . v a c E n d _ d d . v a l u e   = =   ' 0 ' ) {  
 	 	 	 	 a l e r t ( "�l���|��D  � ���t���8Ɣ . " ) ;  
 	 	 	 	 r e t u r n   f a l s e ;  
 	 	 	 } e l s e {  
 	 	 	 	 i f ( c o n f i r m ( "�4� ��̭�D  ��  �X�ܬ�µ�ȮL ? " ) ) {  
 	 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n M o d i f y P r o . k h ' ;  
 	 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;  
 	 	 	 	 }  
 	 	 	 }  
 	 	 } e l s e {  
 	 	 	 i f ( c o n f i r m ( "�4� ��̭�D  ��  �X�ܬ�µ�ȮL ? " ) ) {  
 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n M o d i f y P r o . k h ' ;  
 	 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;  
 	 	 	 }  
 	 	 }  
 	 }  
 	  
 	 f u n c t i o n   d e l H u g a ( ) {  
 	 	 i f ( c o n f i r m ( "�4� ��̭�D  ���  �X�ܬ�µ�ȮL ? " ) ) {  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n D e l e t e . k h ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;  
 	 	 }  
 	 }  
 	  
 	 f u n c t i o n   a c c e p t H u g a ( ) {  
 	 	 i f ( c o n f i r m ( "�4� ��̭�D  ¹�x  �X�ܬ�µ�ȮL ? " ) ) {  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n A c c e p t . k h ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;  
 	 	 }  
 	 }  
 	 f u n c t i o n   d e n y H u g a ( ) {  
 	 	 i f ( c o n f i r m ( "�4� ��̭�D  �p�  �X�ܬ�µ�ȮL ? " ) ) {  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . a c t i o n   =   ' v a c a t i o n D e n y . k h ' ;  
 	 	 	 d o c u m e n t . u s e r _ i n p u t . s u b m i t ( ) ;  
 	 	 }  
 	 }
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
