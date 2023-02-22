//
//  Setting.h
//  heihei
//
//  Created by 谢月甲 on 2017/8/3.
//  Copyright © 2017年 noear. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Setting : NSObject
    
+(id)get:(NSString*)key;
+(void)set:(NSString*)key value:(id)value;
    
+(NSInteger)getInt:(NSString*)key;
+(void)setInt:(NSString*)key value:(NSInteger)value;
    
+(NSString*)getString:(NSString*)key;
+(NSString*)getString:(NSString*)key def:(NSString*)def;
+(void)setString:(NSString*)key value:(NSString*)value;
    
@end
