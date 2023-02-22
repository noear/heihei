//
//  Session.m
//  heihei
//
//  Created by 谢月甲 on 2017/8/3.
//  Copyright © 2017年 noear. All rights reserved.
//

#import "Session.h"
#import "Setting.h"

@implementation Session

    +(NSString*)userName
    {
        return [Setting getString:@"user_name" def:@""];
    }
    
    +(void)setUserName:(NSString*)userName{
        [Setting setString:@"user_name" value:userName];
    }
    
@end
