//
//  Setting.m
//  heihei
//
//  Created by 谢月甲 on 2017/8/3.
//  Copyright © 2017年 noear. All rights reserved.
//

#import "Setting.h"

@implementation Setting

    
+(void)save
    {
        [[NSUserDefaults standardUserDefaults] synchronize];
    }
    
    //============
    
+(id)get:(NSString*)key
    {
        return [[NSUserDefaults standardUserDefaults] objectForKey:key];
    }
+(void)set:(NSString*)key value:(id)value
    {
        [[NSUserDefaults standardUserDefaults] setObject:value forKey:key];
    }
    
+(void)setInt:(NSString*)key value:(NSInteger)value
    {
        [[NSUserDefaults standardUserDefaults] setInteger:value forKey:key];
    }
+(NSInteger)getInt:(NSString*)key
    {
        return [[NSUserDefaults standardUserDefaults] integerForKey:key];
    }
    
    +(NSString*)getString:(NSString*)key{
        return [[NSUserDefaults standardUserDefaults] stringForKey:key];
    }
    +(NSString*)getString:(NSString*)key def:(NSString*)def{
        NSString* tmp = [[NSUserDefaults standardUserDefaults] stringForKey:key];
        if(tmp){
            return tmp;
        }else{
            return def;
        }
    }
    
+(void)setString:(NSString*)key value:(NSString*)value{
    [[NSUserDefaults standardUserDefaults] setObject:value forKey:key];
}
    
    //===============
    
@end
