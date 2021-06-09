//
//  RCTNodeCameraView.h
//  
//
//  Created by Mingliang Chen on 2017/12/12.
//  Copyright © 2017年 NodeMedia. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <NodeMediaClient/NodeMediaClient.h>
#import <React/RCTView.h>

@interface RCTNodeCameraView : UIView <NodePublisherDelegate>
@property (strong, nonatomic) NSString *outputUrl;
@property (nonatomic) BOOL autopreview;
@property (strong,nonatomic) NSDictionary *camera;
@property (strong,nonatomic) NSDictionary *audio;
@property (strong,nonatomic) NSDictionary *video;
@property (nonatomic) BOOL denoise;
@property (nonatomic) BOOL dynamicRateEnable;
@property (nonatomic) NSInteger smoothSkinLevel;
@property (strong, nonatomic) NSString *cryptoKey;
@property (nonatomic, copy) RCTBubblingEventBlock onChange;
@property (nonatomic, copy) RCTBubblingEventBlock onCapturePicture;

@property (nonatomic) BOOL flashEnable;

-(int)startprev;
-(int)stopprev;
-(int)start;
-(int)stop;
-(int)switchCamera;
-(void)capturePicture;

@end
