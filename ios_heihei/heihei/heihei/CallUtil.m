//
//  CallUtil.m
//  heihei
//
//  Created by 谢月甲 on 2017/8/3.
//  Copyright © 2017年 noear. All rights reserved.
//

#import "CallUtil.h"

@implementation CallUtil

    
    /** 异步延时 */
+ (void)asynCall:(int)delayMillis fun:(void(^)())fun
    {
        if (delayMillis > 0) {
            
            double span = (double)(delayMillis/1000.0);
            
            dispatch_after(dispatch_time(DISPATCH_TIME_NOW, (int64_t)(span * NSEC_PER_SEC)), dispatch_get_main_queue(), ^{
                
                fun();
            });
        }
        else {
            
            dispatch_async(dispatch_get_main_queue(), ^{
                
                fun();
            });
        }
    }
    
    /** 默认时间异步 */
+ (void)asynCall:(void(^)())fun
    {
        [self asynCall:10 fun:^{
            
            fun();
        }];
    }
    
    /** 默认时间同步 */
+ (void)mainCall:(void(^)())fun
    {
        dispatch_async(dispatch_get_main_queue(), ^{
            
            fun();
        });
    }
@end
