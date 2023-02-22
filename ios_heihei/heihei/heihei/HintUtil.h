//
//  HintUtil.h
//  heihei
//
//  Created by 谢月甲 on 2017/8/3.
//  Copyright © 2017年 noear. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface HintUtil : NSObject
    
+(void)show:(UIViewController*)from txt:(NSString*)txt;
+(void)show2:(UIViewController*)from txt:(NSString*)txt;
+(void)alert:(UIViewController*)from txt:(NSString*)txt;
    
@end
